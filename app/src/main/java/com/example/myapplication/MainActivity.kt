package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.beans.FanDetailBean
import com.example.myapplication.beans.FanItemBean
import com.example.myapplication.callbacks.FansItemClickCallback
import com.example.myapplication.viewModel.FansListViewModel


class MainActivity : AppCompatActivity() {

    var adapter: FansAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView: RecyclerView = findViewById(R.id.recycler_view)

        adapter = FansAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val model: FansListViewModel by viewModels()

        model.getFanItemBean().value?.let { adapter?.setFanList(it) }
        model.getFanItemBean().observe(this, Observer { fansItemList ->
            // update UI
            adapter?.setFanList(fansItemList)
        })

        adapter!!.setItemClickCallback(object : FansItemClickCallback {
            override fun onFanClicked(position: Int, bean: FanItemBean) {
                var intent = Intent(this@MainActivity, FanDetailActivity::class.java)
                var detailBean: FanDetailBean = FanDetailBean(bean.name!!)
                intent.putExtra("detail", detailBean)
                startActivity(intent)
            }

            override fun onFanFocusClicked(position: Int, bean: FanItemBean) {
                if (bean.focusState == 0) {
                    bean.focusState = 1
                    bean.fansNum++
                } else {
                    bean.focusState = 0
                    bean.fansNum--
                }
                adapter?.notifyItemChanged(position)
            }

        })
    }

    class FansAdapter(context: Context) : RecyclerView.Adapter<FanHolder>() {
        var mContext: Context = context
        var mFanList: List<FanItemBean>? = null

        @Nullable
        private var mItemClickCallback: FansItemClickCallback? = null
        fun setItemClickCallback(callback: FansItemClickCallback) {
            this.mItemClickCallback = callback
        }


        fun setFanList(fanList: List<FanItemBean>) {
            if (mFanList == null) {
                mFanList = fanList
                notifyItemRangeInserted(0, fanList.size);
            } else {
                val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                    override fun getOldListSize(): Int {
                        return mFanList!!.size
                    }

                    override fun getNewListSize(): Int {
                        return fanList.size
                    }

                    override fun areItemsTheSame(
                        oldItemPosition: Int,
                        newItemPosition: Int
                    ): Boolean {
                        return mFanList!!.get(oldItemPosition).name ===
                                fanList.get(newItemPosition).name
                    }

                    override fun areContentsTheSame(
                        oldItemPosition: Int,
                        newItemPosition: Int
                    ): Boolean {
                        val newProduct: FanItemBean = fanList.get(newItemPosition)
                        val oldProduct: FanItemBean = mFanList!!.get(oldItemPosition)
                        return (newProduct.name === oldProduct.name && TextUtils.equals(
                            newProduct.portraitUrl,
                            oldProduct.portraitUrl
                        )
                                && TextUtils.equals(newProduct.name, oldProduct.name)
                                && newProduct.portraitUrl === oldProduct.portraitUrl)
                    }
                })
                mFanList = fanList;
                result.dispatchUpdatesTo(this)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FanHolder {
            return FanHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.layout_fan_item, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return if (mFanList == null) {
                0
            } else {
                mFanList!!.size
            }
        }

        override fun onBindViewHolder(holder: FanHolder, position: Int) {
            holder.itemView.setOnClickListener {   // 跳转到个人主页

                mItemClickCallback?.onFanClicked(position, mFanList!![position])
            }
            holder.followView.setOnClickListener {
                mItemClickCallback?.onFanFocusClicked(position, mFanList!![position])
            }
            val bean = mFanList?.get(position)
            if (bean?.focusState == 0) {
                holder.followView.text = "关注"
                bean.fansNum
            } else {
                holder.followView.text = "已关注"
            }
            holder.tv_name.text = bean?.name
            holder.tv_fans_num.text = "粉丝(" + bean?.fansNum + ")"

        }

    }

    class FanHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_icon: ImageView = itemView.findViewById(R.id.fan_iv_portrait);
        var tv_name: TextView = itemView.findViewById(R.id.fan_tv_name);
        var tv_fans_num: TextView = itemView.findViewById(R.id.fan_tv_num);
        var followView: TextView = itemView.findViewById(R.id.common_follow_view);

    }


}
package com.example.myapplication.db

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.myapplication.AppExecutors
import com.example.myapplication.DataGenerator
import com.example.myapplication.beans.FanItemBean
import com.example.myapplication.dao.FanItemDao
import com.example.myapplication.db.entity.FansItemEntity

//@Database(version = 2, entities = [FansItemEntity::class])
abstract class AppDatabase private constructor(context: Context, executors: AppExecutors) :
    RoomDatabase() {
//    abstract fun productDao(): FanItemDao?
//
//    companion object {
//        const val DATABASE_NAME = "basic-sample-db"
//        private val mIsDatabaseCreated =
//            MutableLiveData<Boolean>()
//        private var sInstance: AppDatabase? = null;
//
//        fun getInstance(context: Context, executors: AppExecutors): AppDatabase? {
//            if (sInstance == null) {
//                synchronized(AppDatabase::class.java) {
//                    if (sInstance == null) {
//                        sInstance = buildDatabase(context.applicationContext, executors)
//                        sInstance?.updateDatabaseCreated(context.applicationContext)
//                    }
//                }
//            }
//            return sInstance
//        }
//
//        private fun buildDatabase(
//            appContext: Context,
//            executors: AppExecutors
//        ): AppDatabase? {
//            return Room.databaseBuilder(appContext, AppDatabase::class.java, DATABASE_NAME)
//                .addCallback(object : Callback() {
//                    override fun onCreate(db: SupportSQLiteDatabase) {
//                        super.onCreate(db)
//                        executors.diskIO.execute {
//
//                            // Add a delay to simulate a long-running operation
//                            addDelay()
//                            // Generate the data for pre-population
//                            val database =
//                                getInstance(appContext, executors)
//                            val products: List<FanItemBean>? =
//                                DataGenerator.generateProducts()
//                            if (database != null) {
//                                if (products != null) {
//                                    insertData(database, products)
//                                }
//                            }
//                            // notify that the database was created and it's ready to be used
//                            database?.setDatabaseCreated()
//                        }
//                    }
//                })
//                .addMigrations(MIGRATION_1_2)
//                .build()
//        }
//
//
//        private fun insertData(
//            database: AppDatabase, products: List<FanItemBean>
//        ) {
//            database.runInTransaction {
////                database.productDao()?.insertAll(products)
//            }
//        }
//
//        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
//            override fun migrate(database: SupportSQLiteDatabase) {
//                database.execSQL(
//                    "CREATE VIRTUAL TABLE IF NOT EXISTS `productsFts` USING FTS4("
//                            + "`name` TEXT, `description` TEXT, content=`products`)"
//                )
//                database.execSQL(
//                    "INSERT INTO productsFts (`rowid`, `name`, `description`) "
//                            + "SELECT `id`, `name`, `description` FROM products"
//                )
//            }
//        }
//
//        private fun addDelay() {
//            try {
//                Thread.sleep(4000)
//            } catch (ignored: InterruptedException) {
//            }
//        }
//
//
//    }
//
//    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
//        TODO("Not yet implemented")
//    }
//
//    override fun createInvalidationTracker(): InvalidationTracker {
//        TODO("Not yet implemented")
//    }
//
//    override fun clearAllTables() {
//        TODO("Not yet implemented")
//    }
//
//    private fun setDatabaseCreated() {
//        mIsDatabaseCreated.postValue(true)
//    }
//
//    private fun updateDatabaseCreated(context: Context) {
//        if (context.getDatabasePath(DATABASE_NAME).exists()) {
//            setDatabaseCreated()
//        }
//    }

}
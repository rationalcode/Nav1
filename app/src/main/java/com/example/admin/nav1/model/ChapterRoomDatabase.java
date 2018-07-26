package com.example.admin.nav1.model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;

@Database(entities = Chapter.class, version = 1,exportSchema = false)
public abstract class ChapterRoomDatabase extends RoomDatabase {

    public abstract ChapterDao chapterDao ();

    private static ChapterRoomDatabase INSTANCE;

//add modifier public to getDatabase
    public static ChapterRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ChapterRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ChapterRoomDatabase.class, "info_database")
                            .allowMainThreadQueries()
                            .addCallback(rdc)
                            .build();

                }
            }
        }

        //Toast.makeText(context,"create DB",Toast.LENGTH_SHORT).show();
        return INSTANCE;

    }

    static RoomDatabase.Callback rdc = new RoomDatabase.Callback() {
        public void onCreate (SupportSQLiteDatabase db) {
            // do something after database has been created
        }
        public void onOpen (SupportSQLiteDatabase db) {
            // do something every time database is open

            new PopulateDB(INSTANCE).execute();

        }
    };

}

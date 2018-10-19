package tech.march.finalsepakbola.data.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*
import tech.march.finalsepakbola.model.db.MatchDb
import tech.march.finalsepakbola.model.db.TeamDb

class DatabaseHelper(ctx: Context): ManagedSQLiteOpenHelper(ctx,
        "FinalSepakbola.db", null, 1) {

    companion object {
        private var instance: DatabaseHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DatabaseHelper {
            if (instance == null) {
                instance = DatabaseHelper(ctx.applicationContext)
            }
            return instance as DatabaseHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(MatchDb.TABLE_MATCHES, true,
                MatchDb.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                MatchDb.MATCHES_ID to TEXT + UNIQUE,
                MatchDb.MATCHES_TIME to TEXT,
                MatchDb.HOME_TEAM to TEXT,
                MatchDb.HOME_SCORE to TEXT,
                MatchDb.AWAY_TEAM to TEXT,
                MatchDb.AWAY_SCORE to TEXT,
                MatchDb.HOME_TEAM_ID to TEXT,
                MatchDb.AWAY_TEAM_ID to TEXT)

        db?.createTable(TeamDb.TABLE_TEAMS, true,
                TeamDb.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                TeamDb.TEAMS_ID to TEXT + UNIQUE,
                TeamDb.TEAMS_NAME to TEXT,
                TeamDb.BADGE_TEAM to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(MatchDb.TABLE_MATCHES, true)
        db?.dropTable(TeamDb.TEAMS_NAME, true)
    }
}
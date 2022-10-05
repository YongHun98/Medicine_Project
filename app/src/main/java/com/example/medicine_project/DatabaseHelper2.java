package com.example.medicine_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Calendar;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    //* 생성, 읽기, 수정 삭제 기능을 코드상에서 구현해주세요( 레이아웃 없어도 됨 )

    //DB_NAME = "medicineDB.db";  //DB이름
    //DB_VERSION = 2; //DB버전
    //생성자
    public DatabaseHelper2(@Nullable Context context) {
        super(context,"medicineDB.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //테이블의 구조는 여기서 설계
        db.execSQL("CREATE TABLE medi (" +
                "mediId INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                "mediName TEXT NOT NULL, " +
                "volume REAL,  " +
                "onetime TEXT NOT NULL,  " +
                "twotime TEXT, " +
                "threetime TEXT, " +
                "mon INTEGER, " +
                "tue INTEGER, " +
                "wed INTEGER, " +
                "thu INTEGER," +
                "fri INTEGER, " +
                "sat INTEGER, " +
                "sun INTEGER, " +
                "memo TEXT, " +
                "onoff INTEGER);");

        //String qry;
        //없으면 썰렁하니 아무 데이터라도 넣어주기
        //qry = "INSERT INTO alarm(name) VALUES('활명수')";
        //db.execSQL(qry);
        //qry = "INSERT INTO alarm(name) VALUES('타이레놀')";
        //db.execSQL(qry);
        //qry = "INSERT INTO alarm(name) VALUES('삐콤정')";
        //db.execSQL(qry);

    }
    //버전 업데이트 될때마다 호출 되는데 마지막에 onCreate도 같이 실행되기 때문에 여기서 먼저 DB에 존재하는 테이블들을 지워줘야함.
    //한마디로 초기화역할


    // 사용자 지정 알람 정보를 알람 테이블에 INSERT 하는 코드
    public void insertAlarm(SQLiteDatabase db, Alarm alarm) {
        // 시간 개수 체크
        switch (alarm.getTime().length) {
            case 1: // 시간 설정이 한 개인 경우
                db.execSQL("INSERT INTO TABLE medi ( mediName, volume, onetime, mon, tue, wed, thu, fri, sat, sun, memo, onoff) VALUES ( " +
                        alarm.getDrug() +"," +
                        alarm.getVolume() + "," +
                        alarm.getTime()[0] + "," +     // 시간 리스트의 첫 번째 인덱스( 시간 한 개 설정했으니깐 )
                        alarm.getDate()[0] + "," +      // 이
                        alarm.getDate()[1] + "," +      // 것
                        alarm.getDate()[2] + "," +      // 들
                        alarm.getDate()[3] + "," +      // 은
                        alarm.getDate()[4] + "," +      // 요
                        alarm.getDate()[5] + "," +      // 일
                        alarm.getDate()[6] + "," +      // 입니다
                        alarm.getMemo() + "," +
                        alarm.isEnabled() + "); " );
                break;
            case 2: // 시간 설정이 두 개인 경우
                db.execSQL("INSERT INTO TABLE medi ( mediName, volume, onetime, twotime, mon, tue, wed, thu, fri, sat, sun, memo, onoff) VALUES ( " +
                        alarm.getDrug() +"," +
                        alarm.getVolume() + "," +
                        alarm.getTime()[0] + "," +     // 시간 리스트의 첫 번째 인덱스( 시간 한 개 설정했으니깐 )
                        alarm.getTime()[1] + "," +     // 시간 리스트의 두 번째 인덱스( 시간 두 개 설정했으니깐 )
                        alarm.getDate()[0] + "," +      // 이
                        alarm.getDate()[1] + "," +      // 것
                        alarm.getDate()[2] + "," +      // 들
                        alarm.getDate()[3] + "," +      // 은
                        alarm.getDate()[4] + "," +      // 요
                        alarm.getDate()[5] + "," +      // 일
                        alarm.getDate()[6] + "," +      // 입니다
                        alarm.getMemo() + "," +
                        alarm.isEnabled() + "); " );
                break;
            case 3: // 시간 설정이 세 개인 경우
                db.execSQL("INSERT INTO TABLE medi ( mediName, volume, onetime, twotime, threetime, mon, tue, wed, thu, fri, sat, sun, memo, onoff) VALUES ( " +
                        alarm.getDrug() +"," +
                        alarm.getVolume() + "," +
                        alarm.getTime()[0] + "," +     // 시간 리스트의 첫 번째 인덱스( 시간 한 개 설정했으니깐 )
                        alarm.getTime()[1] + "," +     // 시간 리스트의 두 번째 인덱스( 시간 두 개 설정했으니깐 )
                        alarm.getTime()[2] + "," +     // 시간 리스트의 세 번째 인덱스( 시간 세 개 설정했으니깐 )
                        alarm.getDate()[0] + "," +      // 이
                        alarm.getDate()[1] + "," +      // 것
                        alarm.getDate()[2] + "," +      // 들
                        alarm.getDate()[3] + "," +      // 은
                        alarm.getDate()[4] + "," +      // 요
                        alarm.getDate()[5] + "," +      // 일
                        alarm.getDate()[6] + "," +      // 입니다
                        alarm.getMemo() + "," +
                        alarm.isEnabled() + "); " );
                break;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String qry = "DROP TABLE IF EXISTS alarm";
        db.execSQL(qry);
        onCreate(db);

    }

// 알람 내용을 리스트에 불러오는 코드
    public ArrayList<ListItem> allListItems() {
        ArrayList<ListItem> listItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT mediId, mediName " +
                    "FROM medi", null);

        // 테이블 끝까지 읽기
        if (cursor != null){
            // 다음 Row로 이동
            while(cursor.moveToNext()){ // 경고 : getReadableDatabase 넣어야 하는지 모름
                int mediId = cursor.getInt(0);    // index of alarmId
                String mediName = cursor.getString(1);  // index of mediName

                listItems.add(new ListItem(mediId, mediName));
            }
        }

        return listItems;
    }

    public ArrayList<PillList> allPListItems() {
        ArrayList<PillList> pListItems = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String now = "";
        Calendar calNow = Calendar.getInstance();
        int numNow = calNow.get(Calendar.DAY_OF_WEEK);
        switch (numNow) {
            case 1:
                now = "일";
                break ;
            case 2:
                now = "월";
                break ;
            case 3:
                now = "화";
                break ;
            case 4:
                now = "수";
                break ;
            case 5:
                now = "목";
                break ;
            case 6:
                now = "금";
                break ;
            case 7:
                now = "토";
                break ;
        }

        return pListItems;
    }

    public void deleteItem(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM medi WHERE mediId = '" + id + "';");

        db.close();
    }
}
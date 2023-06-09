package com.example.w4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    // TODO: 2023-05-25 이거말고
//    ArrayList<String> list;
    // TODO: 2023-05-25 이거사용하기
    List<UserEntity> list;
    Context context;
    UserDao userDao;
//    ArrayList DeleteArray = new ArrayList();

    int id;

//    public MyAdapter(ArrayList<String> arrayList) {
//        this.arrayList = arrayList;
//    }
////    1. 어뎁터 생성하기 - 아이템뷰를 생성하기위함
////    1-1.리사이클러뷰의 어뎁터를 상속받는 마이어뎁터 생성

    // TODO: 2023-05-25 이거말고
//    public MyAdapter(ArrayList list) {
//        this.list = list;
//    }
    // TODO: 2023-05-25 이거사용
    public MyAdapter(List<UserEntity> list,UserDao userDao) {
        this.list = list;
        this.userDao = userDao;
        // TODO: 2023-05-30 블로그 유튜브 보고 하는중 
        notifyDataSetChanged();
    }

//    1. 어뎁터 생성하기 - 아이템뷰를 생성하기위함
//    1-1.리사이클러뷰의 어뎁터를 상속받는 마이어뎁터 생성

    public class ViewHolder extends RecyclerView.ViewHolder {
//        2. 뷰홀더 생성 - 아이템뷰를 저장하는 재활용되는 객체
//        2-1. 텍스트뷰 등의 객체 id를 참조
        Button NameBt;
        Button delBt;
        TextView textView;
        int id;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            NameBt=(Button) itemView.findViewById(R.id.ButtonN);
//            delBt=(Button)itemView.findViewById(R.id.button1);
//                        아마 리사이클러뷰가 아닌 , 메인엑티비티 xml 의 요소를 바꾸려고해서 오류가나는듯

//            NameBt=(Button) itemView.findViewById(R.id.ButtonN);

            NameBt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println(getAdapterPosition());
                    System.out.println(list.get(getAdapterPosition()).id);
                    NameBt.setText("바꿔짐");
                }
            });

            NameBt.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
//                    롱클릭한 개체의 아이디
                    System.out.println(getAdapterPosition());
                    System.out.println(list.get(getAdapterPosition()).id);
//                    System.out.println(list.get(getAdapterPosition()).id);
                    int id = list.get(getAdapterPosition()).id;
//list.get(getAdapterPosition()).selected
                        class UpdateRunnable implements Runnable {
                            @Override
                            public void run() {
                                try {
                                    if (userDao.getSelected(id)==1){
                                        NameBt.setTextSize(50);
                                        System.out.println("업데이트 스레드실행및 업데이트 >1>0");
                                        userDao.setSelected(id,0);
                                        System.out.println("업데이트및 새로고침완료");
                                    }else {
                                        System.out.println("업데이트 스레드실행및 업데이트 >0>1");
                                        userDao.setSelected(id,1);
                                        System.out.println("업데이트및 새로고침완료");
                                    }
                                }
                                catch (Exception e) {

                                }
                            }
                        }
                        UpdateRunnable updateRunnable = new UpdateRunnable();
                        Thread t = new Thread(updateRunnable);
                        t.start();
//                    else {
//                        NameBt.setTextSize(5);
////                        delBt.setText("5555");
////                        아마 리사이클러뷰가 아닌 , 메인엑티비티 xml 의 요소를 바꾸려고해서 오류가나는듯
//                        System.out.println(" 선택된항목의 id는 "+id+" 입니다. ");
////                        list.get(getAdapterPosition()).setSelected(true);
//                        class UpdateRunnable implements Runnable {
//                            @Override
//                            public void run() {
//                                try {
//                                    System.out.println("업데이트 스레드실행및 업데이트2");
//                                    userDao.setSelected(id,1);
//                                    // TODO: 2023-05-26 이걸써야하나? 새로고침의 의미가 있나?
//                                    notifyDataSetChanged();
//                                    System.out.println("업데이트및 새로고침완료");
//                                }
//                                catch (Exception e) {
//
//                                }
//                            }
//                        }
//                        UpdateRunnable updateRunnable = new UpdateRunnable();
//                        Thread t = new Thread(updateRunnable);
//                        t.start();
//                    }
            return true;
                }
            });
            // TODO: 2023-05-25  레이아웃 구조 변경으로 인한 삭제예정 코드
////            순서바꾸기버튼 - 위
//            button_up.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    System.out.println(textView.getText()+" 의 버튼1클릭 ok ");
//                }
//            });
//
////            순서바꾸기버튼 -아래
//            button_down.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    System.out.println("버튼2클릭 ok ");
//                }
//            });
//
//////            삭제버튼
//            button_del.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    UserDatabase db = Room.databaseBuilder(context,
//                            UserDatabase.class, "database-name").build();
//
//                    //Dao 인스턴스 생성 , 데이터베이스에서 정보가져오기.
//                    UserDao userDao = db.userDao();
//
//                    System.out.println("삭제전 어레이리스트 :"+list);
//                    System.out.println("삭제할 항목의 string :"+textView.getText().toString());
//                    System.out.println("삭제할 항목의 id :"+textView.getText().toString());
//
//                    UserEntity1 userDelete = new UserEntity1();
//                    userDelete.Name = "홍길동";
//                    userDelete.id = 0;
//
//                    userDao.delete(userDelete);
//
//
//
////                    System.out.println("새로고침할 항목의 인덱스 :"+list.indexOf(textView.getText().toString()));
////                    int index = arrayList.indexOf(textView.getText().toString());
////                    list.remove(textView.getText().toString());
////                    System.out.println("삭제후 어레이리스트 :"+arrayList);
////                    notifyItemRemoved(index);
////                    System.out.println(arrayList);
////                    System.out.println("버튼3클릭 ok ");
//                }
//            });

//            button_del.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
////                    삭제
//
////                    새로고침
////                    int index = list.indexOf(textView.getText().toString());
////                    notifyItemRemoved(index);
////                    System.out.println(arrayList);
////                    System.out.println("버튼3클릭 ok ");
//                }
//            });

        }
//        public TextView getTextView() {
//            return textView;
//        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        3. onCreateViewHolder 작성 - 뷰홀더를 리턴해줌
//        3-1.리스트 아이템의 ui를 정하는 뷰를 만듬
//        3-2.뷰홀더에 만든뷰를 담아 리턴함
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_ex1,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        4. onBindViewHolder 작성 - 데이터를 넣어줌
//        4-1. 뷰홀더의 텍스트뷰등의 객체에 데이터를 받아서 넣음
        // TODO: 2023-05-25 이거말고
//        holder.textView.setText(list.get(position));
        // TODO: 2023-05-25 이거사용하기
        String name = list.get(position).Name;
        holder.NameBt.setText(name);
//        this.id = list.get(position).id;

        // TODO: 2023-05-30 블로그 유튜브보고 하는중 
        UserEntity userEntity = list.get(position);

//        holder.NameBt.setText(list.get(position).Name);

//        UserEntity userEntity = list.get(position);
//
//        if (userEntity.selected){
//            holder.textView.setTextSize(10);
//        }else {
//            holder.textView.setTextSize(60);
//        }


    }

    @Override
    public int getItemCount() {
//        5. getItemCount 작성 - 데이터의 아이템의 총갯수
//        return .size() , length() . . .
        return list.size();
    }


    public void Changed(){
        notifyDataSetChanged();
    }
}

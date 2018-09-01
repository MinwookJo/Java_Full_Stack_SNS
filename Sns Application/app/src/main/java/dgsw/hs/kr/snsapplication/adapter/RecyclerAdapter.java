package dgsw.hs.kr.snsapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dgsw.hs.kr.snsapplication.R;
import dgsw.hs.kr.snsapplication.activity.DetailActivity;
import dgsw.hs.kr.snsapplication.activity.ListActivity;
import dgsw.hs.kr.snsapplication.activity.LoginActivity;
import dgsw.hs.kr.snsapplication.activity.SignUpActivity;
import dgsw.hs.kr.snsapplication.databinding.ItemRecycelrViewBinding;
import dgsw.hs.kr.snsapplication.network.RetroModel.BoardDomain;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.UserViewHolder> {
    //아이템 리스트
    ArrayList<BoardDomain> mItems;
    //리사이클러뷰 액티비티에서 받아올 콘텍스트
    Context context;

    public RecyclerAdapter(ArrayList<BoardDomain> mItems, Context context) {
        this.mItems = mItems;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycelr_view,parent,false);
        return new UserViewHolder(view);

    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, final int position) {
        holder.binding.titleItem.setText(mItems.get(position).getTitle());
        holder.binding.userNameItem.setText(mItems.get(position).getUserName());

        holder.binding.titleItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("idx",mItems.get(position).getIdx());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    //뷰홀더
    public class UserViewHolder extends RecyclerView.ViewHolder {
        ItemRecycelrViewBinding binding;

        public UserViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}

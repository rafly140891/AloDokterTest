package com.example.alodoktertest.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alodoktertest.DetailActivity;
import com.example.alodoktertest.LoginActivity;
import com.example.alodoktertest.R;
import com.example.alodoktertest.data.SessionManager;
import com.example.alodoktertest.model.ItemCardAdapter;
import com.example.alodoktertest.model.ItemCards;

public class HomeFragment extends Fragment {

    private CardView cardView;

    private HomeViewModel homeViewModel;

    private ItemCardAdapter dataAdapter;

    private RecyclerView.LayoutManager layoutManager;

    private ItemCards[] itemCards;

    SessionManager session;

    private View.OnClickListener onItemClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();
            ItemCards thisItem = itemCards[position];
            Toast.makeText(getActivity(), "You Clicked : " + thisItem.getTitleImage(), Toast.LENGTH_LONG).show();

            session = new SessionManager(getActivity());
            session.setTypeImage(thisItem.getTypeImage());

            Intent intent = new Intent(getActivity(), DetailActivity.class);
            startActivity(intent);
        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        itemCards = new ItemCards[] {
                new ItemCards("Animal", "Kucing", R.drawable.img_kucing1),
                new ItemCards("Food", "Tahu", R.drawable.img_tahu1),
                new ItemCards("Electronic", "Gadget", R.drawable.img_gadget1)
        };
        dataAdapter = new ItemCardAdapter(itemCards);
        layoutManager = new LinearLayoutManager(getActivity());
        final RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(dataAdapter);
        dataAdapter.setOnItemClickListener(onItemClickListener);

        return root;
    }
}
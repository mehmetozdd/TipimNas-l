package com.example.tpe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.tpe.Fragment.HomeFragment;
import com.example.tpe.Fragment.MatchFragment;
import com.example.tpe.Fragment.ProfileFragment;
import com.example.tpe.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.match));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.star));
        binding.bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.name));

        binding.bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;
                switch (item.getId()){
                    case 1:
                        fragment=new HomeFragment();
                        break;
                    case 2:
                        fragment=new MatchFragment();
                        break;
                    case 3:
                        fragment=new ProfileFragment();
                        break;
                }
                loadFragment(fragment);
            }
        });

        binding.bottomNavigation.setCount(1,"10");
        binding.bottomNavigation.show(2,true);
        binding.bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(getApplicationContext(), "You clicked"+item.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(getApplicationContext(), "You reselected"+item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
    }
}
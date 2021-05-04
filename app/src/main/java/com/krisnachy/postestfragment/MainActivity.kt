package com.krisnachy.postestfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "WhatsApp"
        supportActionBar?.elevation = 0.0f

        viewPager2.adapter = renderViewPage(this)
        renderTabLayer()
    }


    inner class renderViewPage(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int {
            return Resource.tabList.size
        }

        override fun createFragment(position: Int): Fragment {
            return Resource.pagerFragments[position]
        }

    }

    private fun renderTabLayer() {
        TabLayoutMediator(tabLayout, viewPager2) {
            tabLayout, position -> tabLayout.text = getString(Resource.tabList[position])
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}


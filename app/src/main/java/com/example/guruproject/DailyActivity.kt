package com.example.guruproject

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

/* 페이지 6번 - 날짜별 activity*/
private const val NUM_PAGES = 3

class DailyActivity : FragmentActivity() {
    private lateinit var mPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily)

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById(R.id.view_pager)

        // The pager adapter, which provides the pages to the view pager widget.
        val pagerAdapter = ScreenSlidePagerAdapter(
            LayoutInflater.from(this@DailyActivity)
        )
        mPager.adapter = pagerAdapter
        mPager.setCurrentItem(1, true)

    }

    private fun showSettingPopup() {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.daily_add_popup, null)
        //val textView: TextView = view.findViewById(R.id.textView)
        //textView.text="dkdkdk"
        val alertDialog = AlertDialog.Builder(this)
            .setTitle("추가")
            .setPositiveButton("저장") { dialog, which ->
                //Toast.makeText(applicationContext, "저장되었습니다", Toast.LENGTH_LONG)
                Log.d("daily", "저장함")
            }
            .setNeutralButton("취소", null)
            .create()
        alertDialog.setView(view)
        alertDialog.show()
        alertDialog.window?.setLayout(1000, 800)
    }

    override fun onBackPressed() {
        if (mPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            mPager.currentItem = mPager.currentItem - 1
        }
    }


    private inner class ScreenSlidePagerAdapter(val layoutInflater: LayoutInflater) :
        PagerAdapter() {
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            when (position) {
                0 -> {
                    val view =
                        layoutInflater.inflate(R.layout.activity_daliy_fragment1, container, false)
                    var add_btn1 = view.findViewById<Button>(R.id.daily_add1)
                    var ok_btn1 = view.findViewById<Button>(R.id.daily_ok1)
                    add_btn1.setOnClickListener{
                        showSettingPopup()
                    }
                    ok_btn1.setOnClickListener{
                        finish()
                    }
                    container.addView(view)
                    return view
                }
                1 -> {
                    val view =
                        layoutInflater.inflate(R.layout.activity_daliy_fragment2, container, false)
                    var add_btn2 = view.findViewById<Button>(R.id.daily_add2)
                    var ok_btn2 = view.findViewById<Button>(R.id.daily_ok2)
                    add_btn2.setOnClickListener{
                        showSettingPopup()
                    }
                    ok_btn2.setOnClickListener{
                        finish()
                    }
                    container.addView(view)
                    return view
                }
                2 -> {
                    val view =
                        layoutInflater.inflate(R.layout.activity_daliy_fragment3, container, false)
                    var add_btn3 = view.findViewById<Button>(R.id.daily_add3)
                    var ok_btn3 = view.findViewById<Button>(R.id.daily_ok3)
                    add_btn3.setOnClickListener{
                        showSettingPopup()
                    }
                    ok_btn3.setOnClickListener{
                        finish()
                    }
                    container.addView(view)
                    return view
                }
                else -> {
                    val view =
                        layoutInflater.inflate(R.layout.activity_daliy_fragment1, container, false)
                    container.addView(view)
                    return view
                }
            }
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object` as View
        }

        override fun getCount(): Int {
            return NUM_PAGES
        }
    }
}
package kz.technodom.technodomsample

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import kotlinx.android.synthetic.main.activity_main.bottom_bar_text_old_price
import kotlinx.android.synthetic.main.activity_main.credit_period_radio_3month
import kotlinx.android.synthetic.main.activity_main.list_accessories
import kotlinx.android.synthetic.main.activity_main.radio_config_color_gray
import kotlinx.android.synthetic.main.activity_main.radio_config_display_13inch
import kotlinx.android.synthetic.main.activity_main.radio_config_memory_128
import kotlinx.android.synthetic.main.activity_main.text_old_price
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.activity_main.view_pager
import kotlinx.android.synthetic.main.activity_main.view_pager_indicator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        text_old_price.paintFlags = text_old_price.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        bottom_bar_text_old_price.paintFlags =
            bottom_bar_text_old_price.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        initAccessoriesList()
        initViewPager()
        credit_period_radio_3month.toggle()
        radio_config_display_13inch.toggle()
        radio_config_memory_128.toggle()
        radio_config_color_gray.toggle()
    }

    private fun initViewPager() {
        val images = listOf(R.drawable.image_accessories_mouse, R.drawable.image_accessories_headset)
        val adapter = ImageViewPagerAdapter(images)
        view_pager.adapter = adapter
        view_pager_indicator.setViewPager(view_pager)
    }

    private fun initAccessoriesList() {
        val adapter = AccessoriesAdapter()
        val list = listOf(
            AccessoriesItem(R.drawable.image_accessories_mouse,
                            "Мышка\nбеспроводная Apple magic mouse",
                            "44 990 ₸",
                            "50 000 ₸"),
            AccessoriesItem(R.drawable.image_accessories_headset,
                            "Наушники\nВставные Apple Bluetooth headset",
                            "84 990 ₸"),
            AccessoriesItem(R.drawable.image_accessories_mouse,
                            "Мышка\nбеспроводная Apple magic mouse",
                            "44 990 ₸",
                            "50 000 ₸"),
            AccessoriesItem(R.drawable.image_accessories_headset,
                            "Наушники\nВставные Apple Bluetooth headset",
                            "84 990 ₸")
        )
        list_accessories.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, OrientationHelper.HORIZONTAL, false)
            this.adapter = adapter
        }
        adapter.submitList(list)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.favorite -> {
                val drawableRes = if (item.isChecked) {
                    R.drawable.ic_favorite_border_accent_unchecked_24dp
                } else {
                    R.drawable.ic_favorite_border_accent_checked_24dp
                }
                item.icon = ContextCompat.getDrawable(this, drawableRes)
                item.isChecked = !item.isChecked
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
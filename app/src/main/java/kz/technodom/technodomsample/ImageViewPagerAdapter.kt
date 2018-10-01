package kz.technodom.technodomsample

import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso

class ImageViewPagerAdapter(private val images: List<Int>): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = ImageView(container.context).apply {
            layoutParams = ViewGroup.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            Picasso.get().load(images[position]).resize(500, 500).into(this)
            setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
        }
        container.addView(view, 0)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return `object` == view
    }

    override fun getCount(): Int = images.size
}
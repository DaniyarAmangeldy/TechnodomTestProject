package kz.technodom.technodomsample

import android.graphics.Paint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_accessories_item.view.layout_accessories_image
import kotlinx.android.synthetic.main.layout_accessories_item.view.layout_accessories_price_current
import kotlinx.android.synthetic.main.layout_accessories_item.view.layout_accessories_price_old
import kotlinx.android.synthetic.main.layout_accessories_item.view.layout_accessories_title

class AccessoriesViewHolder(
    private val view: View
): RecyclerView.ViewHolder(view) {

    private val imageView by lazy { view.layout_accessories_image}
    private val titleTextView by lazy { view.layout_accessories_title}
    private val priceTextView by lazy { view.layout_accessories_price_current}
    private val oldPriceTextView by lazy { view.layout_accessories_price_old}

    fun bind(item: AccessoriesItem) {
        with(item) {
            Picasso.get().load(imageRes).fit().into(imageView)
            titleTextView.text = title
            priceTextView.text = price
            oldPriceTextView.text = oldPrice
            oldPriceTextView.paintFlags = oldPriceTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }
}
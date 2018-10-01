package kz.technodom.technodomsample

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RadioButton
import androidx.core.content.ContextCompat

class TextRadioButton(
    context: Context,
    attributeSet: AttributeSet?,
    defAttrs: Int
): RadioButton(context, attributeSet, defAttrs), View.OnClickListener {

    init {
        setOnClickListener(this)
    }

    constructor(context: Context, attributeSet: AttributeSet): this(context, attributeSet, 0)

    constructor(context: Context): this(context, null, 0)

    override fun setChecked(checked: Boolean) {
        val colorRes = if (checked) {
            android.R.color.black
        } else {
            android.R.color.darker_gray
        }
        setTextColor(ContextCompat.getColor(context, colorRes))
        super.setChecked(checked)
    }

    override fun onClick(p0: View?) {
        toggle()
    }
}
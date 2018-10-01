package kz.technodom.technodomsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class AccessoriesAdapter: ListAdapter<AccessoriesItem, AccessoriesViewHolder>(AccessoriesDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccessoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_accessories_item, parent, false)

        return AccessoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: AccessoriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class AccessoriesDiffUtils: DiffUtil.ItemCallback<AccessoriesItem>() {

    override fun areItemsTheSame(oldItem: AccessoriesItem, newItem: AccessoriesItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: AccessoriesItem, newItem: AccessoriesItem): Boolean {
        return oldItem.oldPrice == newItem.oldPrice &&
            oldItem.title == newItem.title
    }
}
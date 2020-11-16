package eslam.emad.swipegestureexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SwipeLayout
import com.daimajia.swipe.adapters.RecyclerSwipeAdapter
import eslam.emad.swipegestureexample.databinding.ItemBookBinding

class Adapter(private val books: List<Book>, private val onClick: OnClick): RecyclerSwipeAdapter<Adapter.AdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val binding: ItemBookBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_book, parent, false)
        return AdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.binding.book = books[position]
        holder.binding.onClick = onClick

        /**
         *  viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
        holder.binding.swipeItem.addDrag(SwipeLayout.DragEdge.Left, viewHolder.swipeLayout.findViewById(R.id.bottom_wrapper1));
        holder.binding.swipeItem.addDrag(SwipeLayout.DragEdge.Right, viewHolder.swipeLayout.findViewById(R.id.bottom_wraper));
            mItemManger.bindView(viewHolder.itemView, position);
         */

        holder.binding.swipeItem.showMode = SwipeLayout.ShowMode.PullOut
        holder.binding.swipeItem.addDrag(SwipeLayout.DragEdge.Left, holder.binding.leftWrapper);
        holder.binding.swipeItem.addDrag(SwipeLayout.DragEdge.Right, holder.binding.rightWrapper);
        mItemManger.bindView(holder.itemView, position);
    }

    override fun getItemCount() = books.size

    override fun getSwipeLayoutResourceId(position: Int) = R.id.swipe_item

    class AdapterViewHolder(val binding: ItemBookBinding): RecyclerView.ViewHolder(binding.root)
}
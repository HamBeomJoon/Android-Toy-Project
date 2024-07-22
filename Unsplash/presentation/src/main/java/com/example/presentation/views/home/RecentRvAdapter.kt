package com.example.presentation.views.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.PhotoEntity
import com.example.presentation.databinding.ItemRecentImageBinding

class RecentRvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var recentList = mutableListOf<PhotoEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemRecentImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recentList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RecentViewHolder) holder.bind(recentList[position])
    }

    inner class RecentViewHolder(private val binding: ItemRecentImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            // Rv이미지 초기화
//            binding.ivRecentImage.visibility = View.GONE
//            binding.shimmerViewContainer.visibility = View.VISIBLE
        }

        fun bind(item: PhotoEntity) {
            // 이미지 로드
            Glide.with(binding.ivRecentImage)
                .load(item.thumb)
                .into(binding.ivRecentImage)

            // 클릭 이벤트 설정
            itemView.setOnClickListener {
                itemClickListener?.onItemClick(item.id)
            }

            // 3초 후 shimmer를 숨기고 이미지 표시
//            Handler(Looper.getMainLooper()).postDelayed({
//                binding.shimmerViewContainer.visibility = View.GONE
//                binding.ivRecentImage.visibility = View.VISIBLE
//            }, 3000)
        }
    }

    private var itemClickListener: OnItemClickListener? = null

    fun setItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    fun setData(newItems: List<PhotoEntity>) {
        recentList.clear()
        recentList.addAll(newItems)
        notifyDataSetChanged()
    }

    fun addData(newItems: List<PhotoEntity>) {
        val startPosition = recentList.size + 1
        recentList.addAll(newItems)
        notifyItemRangeInserted(startPosition, newItems.size)
    }
}
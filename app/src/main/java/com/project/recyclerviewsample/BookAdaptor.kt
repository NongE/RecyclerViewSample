package com.project.recyclerviewsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.recyclerviewsample.databinding.ItemBookRecyclerViewBinding

class BookAdaptor(private val bookData: MutableList<BookData>) :
    RecyclerView.Adapter<BookAdaptor.BookViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener

    inner class BookViewHolder(private val binding: ItemBookRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClickListener.onClick(it, adapterPosition)
            }

            itemView.setOnLongClickListener {
                onItemClickListener.onLongClick(it, adapterPosition)
            }
        }

        fun bind(bookData: BookData) {
            binding.bookNameText.text = bookData.bookName
            binding.bookPriceText.text = bookData.price
            binding.bookPublisherText.text = bookData.publisher
        }
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
        fun onLongClick(v: View, position: Int): Boolean
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            ItemBookRecyclerViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookData[position])
    }

    override fun getItemCount(): Int {
        return bookData.size
    }
}
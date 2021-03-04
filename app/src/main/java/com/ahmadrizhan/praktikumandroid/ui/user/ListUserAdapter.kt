package com.ahmadrizhan.praktikumandroid.ui.user

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmadrizhan.praktikumandroid.databinding.ItemRowsUserBinding
import com.ahmadrizhan.praktikumandroid.model.Userdata
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListUserAdapter(private val listUser: ArrayList<Userdata>) : RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {
    class ListViewHolder(private val binding: ItemRowsUserBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userdata: Userdata) {
            with(binding) {
                tvItemName.text = userdata.first_name + " " + userdata.last_name
                tvItemEmail.text = userdata.email

                Glide.with(itemView.context)
                    .load(userdata.avatar)
                    .apply(RequestOptions().override(55, 55))
                    .into(ivItemAvatar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowsUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount():Int = listUser.size
}
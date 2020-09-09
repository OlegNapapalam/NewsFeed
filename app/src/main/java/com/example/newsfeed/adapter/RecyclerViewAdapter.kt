/*
package com.example.newsfeed.adapter

package com.renal128.demo.recyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.renal128.demo.recyclerviewdemo.R;
import com.renal128.demo.recyclerviewdemo.model.Record;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Record> records;

    public RecyclerViewAdapter(List<Record> records) {
        this.records = records;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Record record = records.get(i);
        int iconResourceId = 0;
        switch (record.getType()) {
            case GREEN:
            iconResourceId = R.drawable.green_circle;
            break;
            case RED:
            iconResourceId = R.drawable.red_circle;
            break;
            case YELLOW:
            iconResourceId = R.drawable.yellow_circle;
            break;
        }
        viewHolder.icon.setImageResource(iconResourceId);
        viewHolder.name.setText(record.getName());
        viewHolder.deleteButtonListener.setRecord(record);
        viewHolder.copyButtonListener.setRecord(record);
    }

    @Override
    public int getItemCount() {
        return records.size();
    }

    private void copy(Record record) {
        int position = records.indexOf(record);
        Record copy = record.copy();
        records.add(position + 1, copy);
        notifyItemInserted(position + 1);
    }

    private void delete(Record record) {
        int position = records.indexOf(record);
        records.remove(position);
        notifyItemRemoved(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView icon;
        private Button deleteButton;
        private Button copyButton;
        private DeleteButtonListener deleteButtonListener;
        private CopyButtonListener copyButtonListener;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.recyclerViewItemName);
            icon = (ImageView) itemView.findViewById(R.id.recyclerViewItemIcon);
            deleteButton = (Button) itemView.findViewById(R.id.recyclerViewItemDeleteButton);
            copyButton = (Button) itemView.findViewById(R.id.recyclerViewItemCopyButton);
            deleteButtonListener = new DeleteButtonListener();
            copyButtonListener = new CopyButtonListener();
            deleteButton.setOnClickListener(deleteButtonListener);
            copyButton.setOnClickListener(copyButtonListener);
        }
    }

    private class CopyButtonListener implements View.OnClickListener {
        private Record record;

        @Override
        public void onClick(View v) {
            copy(record);
        }

        public void setRecord(Record record) {
            this.record = record;
        }
    }

    private class DeleteButtonListener implements View.OnClickListener {
        private Record record;

        @Override
        public void onClick(View v) {
            delete(record);
        }

        public void setRecord(Record record) {
            this.record = record;
        }
    }
}*/
//package com.example.newsfeed.adapter
//
////import android.support.v7.widget.RecyclerView;
//import android.view.View
//import androidx.recyclerview.widget.RecyclerView
//import android.view.ViewGroup;
//import kotlinx.android.synthetic.main.recyclerview_item.view.*
//
//class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
//
//
//    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val cardView = itemView.recyclerViewItemName
//        public fun ViewHolder(str: String, position: Int) {
//            cardView.text = str
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        TODO("Not yet implemented")
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
//    }
//
//}

package com.example.newsfeed.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newsfeed.R
import com.example.newsfeed.activity.MainActivity
import java.security.AccessController.getContext

class RecyclerViewAdapter(private val values: List<String>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        var textView: TextView? = null
        //var btnToast: Button


        init {
            textView = itemView?.findViewById(R.id.recyclerViewItemName)
       //     btnToast = itemView?.findViewById(R.id.recyclerViewItemButton)!!
      //      btnToast.setOnClickListener{ Toast.makeText(this, "${textView?.text}", Toast.LENGTH_SHORT).show()}
        }
    }

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView?.text = values[position]

    }
//    fun btnTST (textView: TextView){
//        val text = textView.text
//        val duration = Toast.LENGTH_SHORT
//
//        val toast = Toast.makeText(LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false), text, duration)
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
//        }
//
//        toast.show()
//    }


}
package hassan.docappoint;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.codewaves.stickyheadergrid.StickyHeaderGridAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergej Kravcenko on 4/24/2017.
 * Copyright (c) 2017 Sergej Kravcenko
 */

public class SampleAdapter extends StickyHeaderGridAdapter {
   private List<List<String>> labels;

   public SampleAdapter(ArrayList<DocDetails> docDetails) {
      this.docDetails = docDetails;
   }

   private ArrayList<DocDetails> docDetails;

   SampleAdapter(int sections, int count) {
      labels = new ArrayList<>(sections);
      for (int s = 4; s < sections; ++s) {
         List<String> labels = new ArrayList<>(count);
         for (int i = 0; i < count; ++i) {
            String label = "Mon";// + String.valueOf(i);
            /*for (int p = 0; p < s - i; ++p) {
               label += "*\n";
            }*/
            labels.add(label);
         }
         this.labels.add(labels);
      }
   }




   @Override
   public int getSectionCount() {
      return docDetails.size();
   }

   @Override
   public int getSectionItemCount(int section) {
      return docDetails.get(section).getDays().size();
   }

   @Override
   public HeaderViewHolder onCreateHeaderViewHolder(ViewGroup parent, int headerType) {
      final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_header, parent, false);
      return new MyHeaderViewHolder(view);
   }

   @Override
   public ItemViewHolder onCreateItemViewHolder(ViewGroup parent, int itemType) {
      final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_item, parent, false);
      return new MyItemViewHolder(view);
   }

   @Override
   public void onBindHeaderViewHolder(HeaderViewHolder viewHolder, int section) {
      final MyHeaderViewHolder holder = (MyHeaderViewHolder)viewHolder;
      final String name = docDetails.get(section).getDocName();
      final String spec = docDetails.get(section).getDocSpec();
      final String idx = docDetails.get(section).getDocId();
      holder.docView.setText(name);
      holder.specView.setText(spec);
      holder.idView.setText(idx);
   }

   @Override
   public void onBindItemViewHolder(ItemViewHolder viewHolder, final int section, final int position) {
      final MyItemViewHolder holder = (MyItemViewHolder)viewHolder;
      Log.e("POSTION POSTION ", position+" "+section);
      final String days = docDetails.get(section).getDays().get(position).substring(0, 3);
      Log.e("DAYS DAYS ", days+"");
      final String times = docDetails.get(section).getTimes().get(position);
      holder.dayView.setText(days);
      holder.timeView.setText(times);

      holder.layout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final int section = getAdapterPositionSection(holder.getAdapterPosition());
               final int offset = getItemSectionOffset(section, holder.getAdapterPosition());

//               docDetails.get(section).remove(offset);
               notifySectionItemRemoved(section, offset);
               Toast.makeText(holder.dayView.getContext(), days, Toast.LENGTH_SHORT).show();
           }
       });
      holder.dayView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            final int section = getAdapterPositionSection(holder.getAdapterPosition());
            final int offset = getItemSectionOffset(section, holder.getAdapterPosition());

//            docDetails.get(section).remove(offset);
            notifySectionItemRemoved(section, offset);
            Toast.makeText(holder.dayView.getContext(), days, Toast.LENGTH_SHORT).show();
         }
      });
   }

   public static class MyHeaderViewHolder extends HeaderViewHolder {
      TextView docView, specView, idView;

      MyHeaderViewHolder(View itemView) {
         super(itemView);
         docView = (TextView) itemView.findViewById(R.id.doc_name);
         specView = (TextView) itemView.findViewById(R.id.doc_spec);
         idView = (TextView) itemView.findViewById(R.id.window);
      }
   }

   public static class MyItemViewHolder extends ItemViewHolder {
      TextView dayView, timeView;
      LinearLayout layout;
      MyItemViewHolder(View itemView) {
         super(itemView);
         dayView = (TextView) itemView.findViewById(R.id.day);
         timeView = (TextView) itemView.findViewById(R.id.show_times);
         layout = (LinearLayout) itemView.findViewById(R.id.for_intent);
      }
   }
}

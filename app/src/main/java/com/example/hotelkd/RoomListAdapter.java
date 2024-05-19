package com.example.hotelkd;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RoomListAdapter extends RecyclerView.Adapter<RoomListAdapter.RoomViewHolder> {

    private Context context;
    private List<Room> roomList;

    public RoomListAdapter(Context context, List<Room> roomList) {
        this.context = context;
        this.roomList = roomList;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.room_list_item, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room room = roomList.get(position);
        holder.roomIcon.setImageResource(room.getIcon());

        SpannableString s = new SpannableString(room.getName());
        SpannableString v = new SpannableString(room.getPrice());

        // Изменение цвета текста на черный
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Изменение размера текста на 15dp
        s.setSpan(new AbsoluteSizeSpan(15, true), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // Изменение стиля текста на жирный
        s.setSpan(new StyleSpan(Typeface.BOLD), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        v.setSpan(new ForegroundColorSpan(Color.BLACK), 0, v.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        v.setSpan(new AbsoluteSizeSpan(15, true), 0, v.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        v.setSpan(new StyleSpan(Typeface.BOLD), 0, v.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Установите текст для TextViews
        holder.roomName.setText(s);
        holder.roomPrice.setText(v);

        // Измените шрифт
        Typeface typeface = Typeface.create("sans-serif-light", Typeface.NORMAL);
        holder.roomName.setTypeface(typeface);
        holder.roomPrice.setTypeface(typeface);

        holder.itemView.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            SpannableString title = new SpannableString(room.getName());
            SpannableString message = new SpannableString(room.getDescription());
            SpannableString positiveText = new SpannableString("Понятно");

            // Примените желаемый стиль к тексту AlertDialog
            title.setSpan(new ForegroundColorSpan(Color.RED), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            title.setSpan(new AbsoluteSizeSpan(20, true), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            title.setSpan(new StyleSpan(Typeface.BOLD), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            message.setSpan(new ForegroundColorSpan(Color.BLACK), 0, message.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            message.setSpan(new AbsoluteSizeSpan(15, true), 0, message.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            message.setSpan(new StyleSpan(Typeface.BOLD), 0, message.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            positiveText.setSpan(new ForegroundColorSpan(Color.RED), 0, positiveText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            positiveText.setSpan(new AbsoluteSizeSpan(15, true), 0, positiveText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            positiveText.setSpan(new StyleSpan(Typeface.BOLD), 0, positiveText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            builder.setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(positiveText, null);

            AlertDialog b = builder.create();
            b.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    AlertDialog dialog = (AlertDialog) dialogInterface;
                    TextView messageView = (TextView) dialog.findViewById(android.R.id.message);
                    TextView titleView = (TextView) dialog.getWindow().findViewById(android.R.id.title);
                    Button positiveButton = dialog.getButton(DialogInterface.BUTTON_POSITIVE);

                    // Изменение шрифта
                    Typeface typeface = Typeface.create("sans-serif-light", Typeface.NORMAL);
                    if (messageView != null) {
                        messageView.setTypeface(typeface);
                    }
                    if (titleView != null) {
                        titleView.setTypeface(typeface);
                    }
                    if (positiveButton != null) {
                        positiveButton.setTypeface(typeface);
                    }
                }
            });
            b.show();
        });
    }




    @Override
    public int getItemCount() {
        return roomList.size();
    }

    public static class RoomViewHolder extends RecyclerView.ViewHolder {

        ImageView roomIcon;
        TextView roomName;
        TextView roomPrice;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            roomIcon = itemView.findViewById(R.id.roomIcon);
            roomName = itemView.findViewById(R.id.roomName);
            roomPrice = itemView.findViewById(R.id.roomPrice);
        }
    }
}
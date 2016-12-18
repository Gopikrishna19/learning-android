package dev.gopikrishna19.miwok.types;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import dev.gopikrishna19.miwok.R;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words) {

        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item_word, parent, false);
        }

        Word word = getItem(position);
        assert word != null;

        ((TextView) listItem.findViewById(R.id.txtMiwok)).setText(word.getTxtMiwok());
        ((TextView) listItem.findViewById(R.id.txtDefault)).setText(word.getTxtDefault());

        ImageView imgIllustration = (ImageView) listItem.findViewById(R.id.imgIllustration);

        if (word.getImgIllustration() == 0) {
            imgIllustration.setVisibility(View.GONE);
        } else {
            imgIllustration.setImageResource(word.getImgIllustration());
        }

        return listItem;
    }
}

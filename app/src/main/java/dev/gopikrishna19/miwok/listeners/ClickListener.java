package dev.gopikrishna19.miwok.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import dev.gopikrishna19.miwok.ColorsActivity;
import dev.gopikrishna19.miwok.FamilyActivity;
import dev.gopikrishna19.miwok.NumbersActivity;
import dev.gopikrishna19.miwok.PhrasesActivity;
import dev.gopikrishna19.miwok.R;

public class ClickListener implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        Context context = view.getContext();
        Intent intent = null;

        switch (view.getId()) {
            case R.id.colors:
                intent = new Intent(context, ColorsActivity.class);
                break;
            case R.id.family:
                intent = new Intent(context, FamilyActivity.class);
                break;
            case R.id.numbers:
                intent = new Intent(context, NumbersActivity.class);
                break;
            case R.id.phrases:
                intent = new Intent(context, PhrasesActivity.class);
                break;
        }

        if (intent != null) {

            context.startActivity(intent);

        }
    }
}

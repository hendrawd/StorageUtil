package hendrawd.storageutil;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Html;
import android.text.Spanned;
import android.util.TypedValue;
import android.widget.TextView;

import hendrawd.storageutil.library.StorageUtil;

public class MainActivity extends AppCompatActivity {

    private static final float TEXT_SIZE_IN_SP = 25;
    private static final float PADDING_IN_DP = 16;
    private static final float LINE_SPACING_EXTRA_IN_DP = 8;
    private static final float LINE_SPACING_MULTIPLIER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final String[] availableExternalStorages = StorageUtil.getStorageDirectories(this);
        final TextView tvContent = new TextView(this);
        tvContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, TEXT_SIZE_IN_SP);
        tvContent.setLineSpacing(getLineSpacingExtra(), LINE_SPACING_MULTIPLIER);
        final int paddingInPixel = (int) getPadding();
        tvContent.setPadding(paddingInPixel, paddingInPixel, paddingInPixel, paddingInPixel);

        final StringBuilder sbContent = new StringBuilder(getBoldHtmlString("Available external storages:"));
        for (String availableExternalStorage : availableExternalStorages) {
            sbContent.append("<br/>").append(availableExternalStorage);
        }
        tvContent.setText(fromHtml(sbContent.toString()));
        setContentView(tvContent);
    }

    private float getPadding() {
        return dp2px(PADDING_IN_DP);
    }

    private float getLineSpacingExtra() {
        return dp2px(LINE_SPACING_EXTRA_IN_DP);
    }

    private float dp2px(float dp) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                getResources().getDisplayMetrics()
        );
    }

    private String getBoldHtmlString(String string) {
        return "<b>" + string + "</b>";
    }

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String htmlString) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            return Html.fromHtml(htmlString, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(htmlString);
        }
    }
}

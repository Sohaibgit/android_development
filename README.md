# Android Development

**To get color value from colors.xml in Java**\
int colorValue = getResources.getColor(R.color.color_name);

**Units**\
sp = scale independent pixels - best used for text size\
dp = density independent pixles - best used for view's size

**Theme Styles**
```
<resources xmlns:tools="http://schemas.android.com/tools">
    <!-- Base application theme. -->
    <style name="Theme.LuckyNumberApp" parent="Theme.MaterialComponents.DayNight.DarkActionBar">
        <!-- Primary brand color. -->
        <item name="colorPrimary">@color/purple_500</item>
        <!-- Status Bar -->
        <item name="colorPrimaryVariant">@color/purple_700</item>
        <!-- Text Color on Buttons -->
        <item name="colorOnPrimary">@color/white</item>
        <!-- Secondary brand color. EditText -->
        <item name="colorSecondary">@color/teal_200</item>
        <item name="colorSecondaryVariant">@color/teal_700</item>
        <item name="colorOnSecondary">@color/black</item>
        <!-- Status bar color. -->
        <item name="android:statusBarColor">?attr/colorPrimaryVariant</item>
        <!-- Customize your theme here. -->
    </style>
</resources>
```

**APIs**\
Programmable Web API Directory: http://www.programmableweb.com/apis/directory \
Google APIs Explorer: https://developers.google.com/apis-explorer/#p/ \
Data.gov: http://data.gov

**Tips for building a great UI**\
https://developer.android.com/develop/ui

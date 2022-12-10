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

**Parsing JSON in Android**\
https://www.tutorialspoint.com/android/android_json_parser.htm

**Code Example**
```
String strJson="
		{
			\"Employee\" :[
			{
				\"id\":\"01\",
				\"name\":\"Gopal Varma\",
				\"salary\":\"500000\"
			},
			{
				\"id\":\"02\",
				\"name\":\"Sairamkrishna\",
				\"salary\":\"500000\"
			},
			{
				\"id\":\"03\",
				\"name\":\"Sathish kallakuri\",
				\"salary\":\"600000\"
			}
			]
		}";

		String data = "";
		try {
			JSONObject jsonRootObject = new JSONObject(strJson);

			//Get the instance of JSONArray that contains JSONObjects
			JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");

			//Iterate the jsonArray and print the info of JSONObjects
			for(int i=0; i < jsonArray.length(); i++){
				JSONObject JSONObject = jsonArray.getJSONObject(i);

				in id = Integer.parseInt(jsonObject.optString("id").toString());
				String name = jsonObject.optString("name").toString();
				float salary = Float.parseFloat(jsonObject.optString("salary").toString());

				data += "Node"+i+" : \n id= "+ id +" \n Name= "+ name +" \n Salary= "+ salary +" \n";
			}
			output.setText(data);
		} 
        catch (JSONException e )
        {
            e printStackTrace();
        }
```

**Drawable Shapes**\
https://guides.codepath.com/android/Drawables \
https://developer.android.com/guide/topics/resources/drawable-resource.html?utm_source=udacity&utm_medium=course&utm_campaign=android_basics#Shape



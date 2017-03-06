package comtelekpsi.github.caesar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtIn;
    EditText txtOut;
    TextView keyText;
    SeekBar seek;
    Switch deSwitch;
    int shAmt = 0;
    char de;


    public String inToOut (String input, int shAmt) {

        String out = "";

        for (int i = 0; i < input.length(); i++) {
            char u = input.charAt(i);
            //capital
            if (u >= 'A' && u <= 'Z') {
                //decode
                if (de == ('d')) {
                    u += shAmt;
                    if (u > 'Z')
                        u -= 26;
                    //encode
                } else {
                    u -= shAmt;
                    if (u < 'A')
                        u += 26;
                }
            }

            //lowercase
            if (u >= 'a' && u <= 'z') {
                //decode
                if (de == ('d')) {
                    u += shAmt;
                    if (u > 'z')
                        u -= 26;
                    //encode
                } else {
                    u -= shAmt;
                    if (u < 'a')
                        u += 26;
                }
            }

			/*if (u>='0' && u<='9'){
				if (de==('d')){
					u+=(key%10);
					if (u>'9')
						u-=10;
				}
				else{
					u-=(key%10);
					if (u<'A')
						u+=10;
				}
			}
            */
            out += u;
        }
        return out;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtIn = (EditText) findViewById(R.id.txtIn);
        txtOut = (EditText) findViewById(R.id.txtOut);
        txtOut.setFocusable(false);

        keyText = (TextView) findViewById(R.id.keyText);
        seek= (SeekBar) findViewById(R.id.seek);
        deSwitch = (Switch) findViewById(R.id.deSwitch);

        deSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    de='d';
                else
                    de='e';
                //run en/decoder if switch is pressed
                shAmt=seek.getProgress();
                keyText.setText("Current Key: "+shAmt);
                String temp=inToOut(txtIn.getText().toString(),shAmt);
                txtOut.setText(temp);
            }
        });

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //change output as it scrolls
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                shAmt=seekBar.getProgress();
                keyText.setText("Current Key: "+shAmt);
                String temp=inToOut(txtIn.getText().toString(),shAmt);
                txtOut.setText(temp);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


}

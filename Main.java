package exe4que.calcuv1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends ActionBarActivity {

    TextView lblDisplay;
    Button btnBorrar;

    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnPun;
    Button btnIgual;
    Button btnDiv;
    Button btnMult;
    Button btnRes;
    Button btnSum;

    double term1 = 0;
    String operacion = "";
    double term2 = 0;
    String bufferAux = "";

    boolean banderaPunto = false;
    boolean banderaResultado = false;

    int contadorOperaciones = 0;
    boolean seIngresoNumero = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblDisplay = (TextView) findViewById(R.id.lblDisplay);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnPun = (Button) findViewById(R.id.btnPun);
        btnIgual = (Button) findViewById(R.id.btnIgual);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnRes = (Button) findViewById(R.id.btnRes);
        btnSum = (Button) findViewById(R.id.btnSum);





    }

    public void borrar()
    {
        bufferAux = "";
        banderaPunto = false;
        actualizarDisplay();
    }

    public void eventoBorrar (View v)
    {
        borrar();
        operacion = "";
        contadorOperaciones = 0;
    }

    public void evento0 (View v)
    {
        seIngresoNumero = true;
        borrarDisplayDespuesDeResultado();
        bufferAux += "0";
        actualizarDisplay();
    }

    public void evento1 (View v)
    {
        eventoNumero("1");
    }

    public void evento2 (View v)
    {
        eventoNumero("2");
    }

    public void evento3 (View v)
    {
        eventoNumero("3");
    }

    public void evento4 (View v)
    {
        eventoNumero("4");
    }

    public void evento5 (View v)
    {
        eventoNumero("5");
    }

    public void evento6 (View v)
    {
        eventoNumero("6");
    }

    public void evento7 (View v)
    {
        eventoNumero("7");
    }

    public void evento8 (View v)
    {
        eventoNumero("8");
    }

    public void evento9 (View v)
    {
        eventoNumero("9");
    }

    public void eventoPun (View v)
    {
        if (banderaPunto == false) {
            borrarDisplayDespuesDeResultado();
            bufferAux += ".";
            banderaPunto = true;
            actualizarDisplay();
        }

    }

    public void eventoDiv (View v)
    {
        eventoOperacion("Div");
    }

    public void eventoMult (View v)
    {
        eventoOperacion("Mult");
    }
    public void eventoRes (View v)
    {
        eventoOperacion("Res");
    }

    public void eventoSum (View v)
    {
        eventoOperacion("Sum");
    }

    private void eventoNumero (String n)
    {
        seIngresoNumero = true;
        borrarDisplayDespuesDeResultado();
        bufferAux += n;
        actualizarDisplay();
    }

    private void eventoOperacion (String o)
    {
        if (bufferAux != "") {
            if (!(contadorOperaciones > 0)) {
                guardarOperacion(o);
                banderaResultado = false;
                borrar();
            }else{
                resolver();
                guardarOperacion(o);
                banderaResultado = true;
            }
        }
        seIngresoNumero = false;

    }

    public void eventoIgual(View v)
    {
        resolver();
    }

    public void resolver(){
        /*if (banderaResultado == true){
            bufferAux="";
            banderaResultado = false;
        }*/
        //if (bufferAux != "") {
            if (seIngresoNumero) {
                if (operacion != ""){
                    term2 = Double.parseDouble(bufferAux);

                    if (operacion == "Sum") {
                        bufferAux = String.valueOf(term1 + term2);
                        term1 = term1 + term2;
                        term2 = 0;
                    }

                    if (operacion == "Res") {
                        bufferAux = String.valueOf(term1 - term2);
                        term1 = term1 - term2;
                        term2 = 0;
                    }

                    if (operacion == "Mult") {
                        bufferAux = String.valueOf(term1 * term2);
                        term1 = term1 * term2;
                        term2 = 0;
                    }

                    if (operacion == "Div") {
                        if (term2 != 0) {
                            bufferAux = String.valueOf(term1 / term2);
                            term1 = term1 / term2;
                        } else {
                            bufferAux = "Math Error";
                            term1 = 0;
                        }
                        term2 = 0;
                    }
                }else{
                    try{term1 = Double.parseDouble(bufferAux);}catch(Exception e){};
                }
            }else{
                bufferAux = String.valueOf(term1);
            }
        /*}else{
            term1=0;
            bufferAux = String.valueOf(term1);
            term2=0;
        }*/
        banderaResultado = true;
        contadorOperaciones = 0;
        operacion ="";
        actualizarDisplay();
    }

    public void borrarDisplayDespuesDeResultado(){
        if(banderaResultado==true){
            bufferAux="";
            banderaResultado = false;
        }
    }

    public void guardarOperacion(String s)
    {
        operacion = s;
        contadorOperaciones++;
        try{term1 = Double.parseDouble(bufferAux);}catch(Exception e){};
    }
    

    public void actualizarDisplay()
    {
        lblDisplay.setText(bufferAux);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

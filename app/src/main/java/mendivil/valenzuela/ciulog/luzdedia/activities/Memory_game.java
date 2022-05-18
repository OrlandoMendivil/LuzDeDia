package mendivil.valenzuela.ciulog.luzdedia.activities;

import android.app.Activity;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import mendivil.valenzuela.ciulog.luzdedia.R;

public class Memory_game extends Activity {

    ImageButton imb00,imb01,imb02,imb03,imb04,imb05,imb06,imb07,imb08,imb09,imb10,imb11,imb12,imb13,imb14,imb15;
    ImageButton[] tablero = new ImageButton[16];
    Button reiniciar, salir;
    TextView tv_puntuacion;
    int puntuacion;
    int aciertos;

    int[] imagenes;
    int fondo;

    ArrayList<Integer> arregloDesordenado;
    ImageButton primero;
    int numeroPri, numeroSeg;
    boolean bloqueo = false;
    final Handler handler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game);
        comenzar();
    }

    private void cargarTablero(){
        imb00 = findViewById(R.id.btn00);
        imb01 = findViewById(R.id.btn01);
        imb02 = findViewById(R.id.btn02);
        imb03 = findViewById(R.id.btn03);
        imb04 = findViewById(R.id.btn04);
        imb05 = findViewById(R.id.btn05);
        imb06 = findViewById(R.id.btn06);
        imb07 = findViewById(R.id.btn07);
        imb08 = findViewById(R.id.btn08);
        imb09 = findViewById(R.id.btn09);
        imb10 = findViewById(R.id.btn10);
        imb11 = findViewById(R.id.btn11);
        imb12 = findViewById(R.id.btn12);
        imb13 = findViewById(R.id.btn13);
        imb14 = findViewById(R.id.btn14);
        imb15 = findViewById(R.id.btn15);

        tablero[0] = imb00;
        tablero[1] = imb01;
        tablero[2] = imb02;
        tablero[3] = imb03;
        tablero[4] = imb04;
        tablero[5] = imb05;
        tablero[6] = imb06;
        tablero[7] = imb07;
        tablero[8] = imb08;
        tablero[9] = imb09;
        tablero[10] = imb10;
        tablero[11] = imb11;
        tablero[12] = imb12;
        tablero[13] = imb13;
        tablero[14] = imb14;
        tablero[15] = imb15;
    }

    private void activarBotones(){
        reiniciar = findViewById(R.id.btnReiniciar);
        salir = findViewById(R.id.btnSalir);
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comenzar();
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void cargarTexto(){
        tv_puntuacion = findViewById(R.id.tv_puntos);
        puntuacion = 0;
        aciertos = 0;
        tv_puntuacion.setText("");
    }

    private void cargarImg(){
        imagenes = new int[]{
                R.drawable.la0,
                R.drawable.la1,
                R.drawable.la2,
                R.drawable.la3,
                R.drawable.la4,
                R.drawable.la5,
                R.drawable.la6,
                R.drawable.la7,
        };
        fondo = R.drawable.fondo2;
    }

    private ArrayList<Integer> revolver(int size){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i=0;i<size*2;i++){
            result.add(i % size);
        }
        Collections.shuffle(result);
        return result;
    }

    private void comprobar(int i, final ImageButton img){
       if (primero == null){
           primero = img;
           primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
           primero.setImageResource(imagenes[arregloDesordenado.get(i)]);
           primero.setEnabled(false);
           numeroPri = arregloDesordenado.get(i);
       }else{
           bloqueo = true;
           img.setScaleType(ImageView.ScaleType.CENTER_CROP);
           img.setImageResource(imagenes[arregloDesordenado.get(i)]);
           img.setEnabled(false);
           numeroSeg = arregloDesordenado.get(i);
           if (numeroPri == numeroSeg){
                primero = null;
                bloqueo = false;
                aciertos++;
                puntuacion++;
                if (aciertos == imagenes.length){
                    tv_puntuacion.setText("¡¡Has Ganado!!\n ¡¡Felicidades!!");
                }
           }else{
               handler.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       primero.setScaleType(ImageView.ScaleType.CENTER_CROP);
                       primero.setImageResource(fondo);
                       primero.setEnabled(true);
                       img.setScaleType(ImageView.ScaleType.CENTER_CROP);
                       img.setImageResource(fondo);
                       img.setEnabled(true);
                       bloqueo = false;
                       primero = null;
                   }
               }, 1000);
           }
       }
    }

    private void comenzar(){
        cargarTablero();
        activarBotones();
        cargarTexto();
        cargarImg();
        arregloDesordenado = revolver(imagenes.length);
        for (int i=0; i<tablero.length;i++){
            tablero[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
            tablero[i].setImageResource(imagenes[arregloDesordenado.get(i)]);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<tablero.length;i++){
                    tablero[i].setScaleType(ImageView.ScaleType.CENTER_CROP);
                    tablero[i].setImageResource(fondo);
                }
            }
        }, 500);
        for (int i=0;i<tablero.length;i++){
            final int j = i;
            tablero[i].setEnabled(true);
            tablero[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!bloqueo){
                        comprobar(j, tablero[j]);
                    }
                }
            });
        }
    }
}

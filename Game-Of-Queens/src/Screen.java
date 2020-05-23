/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Screen {
    //Declaration of all calculator's components.
    JPanel windowContent;
    JTextField displayField;
    JButton buttonArray[];
    JPanel pl;
    JFrame frame = new JFrame("Tabuleiro");
    //Constructor creates the components in memory and adds the to the frame using combination of Borderlayout.
    Tela(LinkedList<Queens> lista) {
        windowContent= new JPanel();
    // Set the layout manager for this panel
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);
    //Create the display field and place it in the North area of the window
        displayField = new JTextField(30);
        windowContent.add("North",displayField);
    //Create the panel with the GridLayout that will contain 12 buttons - 10 numeric ones, and button with the points
    //and the equal sign.
        pl = new JPanel ();
        GridLayout gl =new GridLayout(0,8);
        pl.setLayout(gl);
    //Create button field and place it in the North area of the window
        int linha=0;
        int coluna=0;
        int contagem=1;
        for(int x=0; x< 64; x++){
            
            boolean temRainhaNessaPosicao=false;
            for(int checaPosicoesRainha=0; checaPosicoesRainha < lista.size(); checaPosicoesRainha++){
                if(lista.get(checaPosicoesRainha).getLinha()==linha &&lista.get(checaPosicoesRainha).getColuna() ==coluna){
                    temRainhaNessaPosicao=true;
                    break;
                }
            }
            
            JButton btn = new JButton(Integer.toString(linha).concat(Integer.toString(coluna)));
            if(temRainhaNessaPosicao){
                btn.setBackground(Color.red);
            }
            else{
                 btn.setBackground(Color.white);
            }
            
            
            if( contagem%8==0){
                linha++;
                coluna=0;
            }
            else{
                coluna++;
            }
            contagem++;
            pl.add(btn);
        }
    //Add the panel pl to the center area of the window
        windowContent.add("Center",pl);
    //Create the frame and set its content pane
        
        frame.setContentPane(windowContent);
    //set the size of the window to be big enough to accomodate all controls.
        frame.pack();
    //Finnaly, display the window
        frame.setVisible(true);
    }

    public void mataTela(){
        frame.dispose();
    }
    
    //construtor que vc usa quando quer mostra a tela com a ajuda
    Tela(LinkedList<Rainha> lista, Map<Integer, List<Rainha>> listaAtaquesPorRainha) {
        windowContent= new JPanel();
    // Set the layout manager for this panel
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);
    //Create the display field and place it in the North area of the window
        displayField = new JTextField(30);
        windowContent.add("North",displayField);
    //Create the panel with the GridLayout that will contain 12 buttons - 10 numeric ones, and button with the points
    //and the equal sign.
        pl = new JPanel ();
        GridLayout gl =new GridLayout(0,8);
        pl.setLayout(gl);
    //Create button field and place it in the North area of the window
        int linha=0;
        int coluna=0;
        int contagem=1;
        for(int x=0; x< 64; x++){
            
            boolean temRainhaNessaPosicao=false;
            //verifica se existe uma rainha na posição que o botão está sendo inserido
            for(int checaPosicoesRainha=0; checaPosicoesRainha < lista.size(); checaPosicoesRainha++){
                if(lista.get(checaPosicoesRainha).getLinha()==linha &&lista.get(checaPosicoesRainha).getColuna() ==coluna){
                    temRainhaNessaPosicao=true;
                    break;
                }
            }
            
            //verifica se nessa posição alguma rainha pode atacar
            boolean alguemAtacaEssaPosicao=false;
            
            for(int chavesDoMapa=1; chavesDoMapa<=listaAtaquesPorRainha.size(); chavesDoMapa++){
                for(int verificaLista=0; verificaLista<listaAtaquesPorRainha.get(chavesDoMapa).size(); verificaLista++){
                    if(listaAtaquesPorRainha.get(chavesDoMapa).get(verificaLista).getLinha()==linha&&
                       listaAtaquesPorRainha.get(chavesDoMapa).get(verificaLista).getColuna()==coluna){
                        alguemAtacaEssaPosicao=true;
                        break;
                    }
                }
            }
            
            JButton btn = new JButton(Integer.toString(linha).concat(Integer.toString(coluna)));
            if(temRainhaNessaPosicao){
                btn.setBackground(Color.red);
            }
            else if(alguemAtacaEssaPosicao){
                 btn.setBackground(Color.blue);
            }
            else{
                 btn.setBackground(Color.white);
            }
            
            
            if( contagem%8==0){
                linha++;
                coluna=0;
            }
            else{
                coluna++;
            }
            contagem++;
            pl.add(btn);
        }
    //Add the panel pl to the center area of the window
        windowContent.add("Center",pl);
    //Create the frame and set its content pane
        
        frame.setContentPane(windowContent);
    //set the size of the window to be big enough to accomodate all controls.
        frame.pack();
    //Finnaly, display the window
        frame.setVisible(true);
    }
   

}

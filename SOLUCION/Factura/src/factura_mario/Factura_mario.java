package factura_mario;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;


public class Factura_mario {
    public static void main(String[] args) {
        
        
        try {
            
        Random random = new Random();    
        File inventario = new File("data/productos.txt");
        Scanner inv = new Scanner(inventario);
        Scanner factura = new Scanner (System.in);
        FileWriter fw = new FileWriter("data/datos.txt",true);
        PrintWriter pw = new PrintWriter(fw);
        int c,entrada;
        int cantidad;
        cantidad=1;
        c = 0;
        String datos_cliente[] = new String [5];
         int f;
        f = inven(1);
        
        int l[] = new int [f];
        float  l2[] = new  float [f];
        String l1[] = new String [f];
        
        for (int p1 = 0; p1 <= f-1;p1++){
            l2[p1] = 0 ;
        }
        for (int p1 = 0; p1 <= f-1;p1++){
            l[p1] = 0 ;
        }
        for (int p1 = 0; p1 <= f-1;p1++){
            l1 [p1] = "." ;
        }
            
        System.out.println("+------------------------+");
        System.out.println("|1) Facturar nueva venta |");
        System.out.println("+------------------------+");
        System.out.println("|2) Mostrar inventario   |");
        System.out.println("+------------------------+");
        System.out.print("Ingrese cual de las siguientes opciones desea: ");
        entrada = factura.nextInt();
        
        if (entrada == 2){
            inventario(c);
        }
          
        if (entrada == 1){
            for(int n = 0 ; n <= 4 ; n++){
            datos(datos_cliente,n);   
            }
  
        int numeroAleatorio = random.nextInt(f-1);

               String [] Nombre ;
                
               for (c = 0; c <= f-1; c++){
                   
                   if (numeroAleatorio < 0){
                       numeroAleatorio = numeroAleatorio + 1;
                   }
                    Nombre = inv.nextLine().split(";");
                    
                 if (numeroAleatorio == c ){
                     
                    l1[c]=Nombre [0];
                    l2[c]= Float.parseFloat (Nombre[1]) ;
                     
                  }
                 
                  if (numeroAleatorio == c ){
                     
                   int cantidadAleatoria = random.nextInt(Integer.parseInt (Nombre[2]));
                   
                    numeroAleatorio = numeroAleatorio + 1;
                    cantidad =  cantidadAleatoria ;
                    
                    l[c] = cantidad ;    
                  }
                
                 
                 
                }
                inv.close();
                                
                factura.nextLine();      
                
                pw.println(" ");   
            pw.println("                                   SUPERMAXI                                ");
            pw.println(" +------------------------------------------------------------------------+");
            pw.println(" |                            FACTURA DE COMPRAS                          |");
            pw.printf(" |  %46s %24s%n","Nro de Factura. 000001","|");
            pw.println(" | Dirección: 18 De Nomviembre                    R.U.C: 1790016919001    |");
            pw.println(" | Loja,110102                                    TELEFONO:(07)257-0558   |");
            pw.println(" +------------------------------------------------------------------------+");
            pw.printf(" | Cliente: %-39s   Cedula: %-10s  |%n ",datos_cliente[0],datos_cliente[1]);
            pw.printf("| Direccion: %-39s Telefono: %-10s|%n ",datos_cliente[2],datos_cliente[3]);
            pw.printf("| Correo Electronico: %-50s |%n ",datos_cliente[4]);
            pw.println("+----------+----------------------------+-----------------+--------------+");
            pw.println(" | Cantidad | Item                       | Precio Unitario | Precio Total |");
            pw.println(" +----------+----------------------------+-----------------+--------------+");
            
            float subtotal;
            float iva,total;
            subtotal = 0;
            c = 0;
            
            while (c <= f-1){
                
                if (l[c] > 0){
                    pw.printf(" | %5d    | %-24s   | %,10.2f      | %,9.2f    |%n ",l[c],l1[c],l2[c],(l[c]*l2[c]));
                    pw.println("+----------+----------------------------+-----------------+--------------+");  
                    subtotal = subtotal + (l[c]*l2[c]); 
                }
                    
                c = c+1;
            }
            iva = (float) (subtotal * 0.12);
            total = (iva + subtotal)  ; 
            pw.printf(" |%39s|%15s  |%10.2f    | %n ","","Subtotal",subtotal);
            pw.printf("|%39s|%15s  |%10.2f    |%n",""," IVA 12%", iva);
            pw.printf(" |%39s|%15s  |%10.2f    |%n","","Total a pagar",total);
            pw.println(" +----------+----------------------------+-----------------+--------------+");    
        pw.close();  
        inv.close();
        }
            
        }catch (Exception e){
            System.err.println("ERROR: "+ e.toString()); 
        }  

    }
   public static void inventario(int c){  
        try {
            File inventario = new File("data/productos.txt");
            Scanner inv = new Scanner(inventario);
            int contador;
            contador = 0;
            String[] Nombre ;
            System.out.println("\nINVENTARIO DEL SUPERMAXI");
            System.out.println("+-------------------+----------+----------+--------------------+");
            System.out.println("|      Articulos    | Precio   | Cantidad | Fecha de caducidad |");
            System.out.println("+-------------------+----------+----------+--------------------+");
            while(inv.hasNextLine() ){
                Nombre = inv.nextLine().split(";");
                System.out.printf("| %-3d) %-12s | %6s   | %6s   | %15S    | %n",(contador = contador + 1),Nombre[0],Nombre[1],Nombre[2],Nombre[3]); 
                System.out.println("+-------------------+----------+----------+--------------------+");
                c = c+1;
            }
        }catch (Exception e){
            System.err.println("ERROR: "+ e.toString()); 
        }     
   }
   
   public static String datos( String [] datosC, int c){
        Scanner in = new Scanner(System.in);
        
            if (c==0){
            System.out.print("\nIngrese sus nombres y apellidos: ");
            datosC[c] = in.nextLine();
            }
            if (c==1){
            System.out.print("Ingrese su numero de cedula: ");
            datosC[c] = in.nextLine();
            }
            if (c==2){
            System.out.print("Ingrese su direccion: ");
            datosC[c] = in.nextLine();
            }  
            if (c==3){
            System.out.print("Ingrese su numero de telefono: ");
            datosC[c] = in.nextLine();
            }
            if(c==4){
            System.out.print("Ingrese su correo electronico: ");
            datosC[c] = in.nextLine();
            }
        return datosC[c] ;
    }
   
     public static int inven (int c){
        int f;
        f = 0;
        try {
            File inventario = new File("data/productos.txt");
            Scanner inv = new Scanner(inventario);
            String[] Nombre ;
            while(inv.hasNextLine() ){
                Nombre = inv.nextLine().split(",");
                f = f+1;
            }
        }catch (Exception e){
            System.err.println("ERROR: "+ e.toString()); 
        }     
        return f;
    }
   
}

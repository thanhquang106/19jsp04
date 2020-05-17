package MayATM;



public class TaiKhoan {
    private int matk;
    private String password;
    private double sodu;
    private String tenkh;
   
    public TaiKhoan(){
        matk=0;
        password="";
        sodu=0;
        tenkh="";
    }
  
    public void setmatk(int mtk){
        this.matk =mtk;
    }
    public int getmatk(){
        return this.matk;
    }
    public void setPassword(String pass){
        this.password =pass;
    }
 
    public String getPassword(){
        return this.password;
    }
    public void setsodu(double sd){
        this.sodu= sd;
    }
    
    public double getsodu(){
        return this.sodu;
    }
    public void settenkh(String tkh){
        this.tenkh= tkh;
    }
   
    public String gettenkh(){
        return this.tenkh;
    }
    public boolean ktra(int mtk, String pass){
        
        return mtk==matk && pass.equals(password);
    }
    public boolean ruttien(double sodu){
        
        if(sodu < this.sodu){
            this.sodu -=sodu;
            return true;
        }else
            return false;
    }
    public boolean them(double sodu){
       
        if(sodu >0){
            this.sodu +=sodu;
            return true;
        }else
            return false;
    }           
}
   
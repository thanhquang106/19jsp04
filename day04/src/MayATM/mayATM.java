package MayATM;



import java.util.Scanner;


public class mayATM {

      public static void main(String[] args) {
         System.out.println("Chuong trinh mo ta atm");
         Scanner sc = new Scanner(System.in);
         // Tao mot tai khoan va gan gia tri cho no
         TaiKhoan acc1 = newtaikhoan(1,"abc123", 100, "Nguyen Van A");
                 
         String choice="y";
         while(choice.equalsIgnoreCase("y"))
         {
             // Khoi tao menu
             System.out.println("ban muon thuc hien chức năng nào: ");
             System.out.println("1-Đăng nhập");
             System.out.println("2-Xem thông tin tài khoản");
             System.out.println("3-Rút tiền ");
             System.out.println("4-chuyển khoản");
             
             int lc = sc.nextInt();
             switch(lc)
             {
                case 1: 
                    //Goi ham login 
                     if(login(acc1)){
                        System.out.println("Đăng nhập thành công");
                    }else
                        System.out.println("Đăng nhập thất bại"); 
                    break;
                case 2: 
                    // Goi ham xem so du
                    xemtt(acc1); 
                    break;
                case 3: 
                    // Goi ham rut tien
                    if (rut(acc1)){
                        System.out.println("vui lòng chờ nhận tiền");
                    }else
                        System.out.println("yêu cầu thất bại");   
                    break;
                case 4: 
                    // Thêm tài khoản thứ 2 để nhận tiền
                        TaiKhoan acc2 = newtaikhoan(2, "12345", 50, "Tran Van B");
                        // Goi thu tuc chuyển tiền
                        if(chuyen(acc1, acc2))
                        {
                            System.out.println("số tiền đã được chuyển");
                        }else
                            System.out.println("yêu cầu thất bại");
                        break;
                default: System.out.println("Lựa chọn không phù hợp");
                    break;
             }//End switch... case
             System.out.println("bạn có muốn tiếp tục? ");
             choice = sc.next();
             System.out.println();
            
         }// End while                      
    }//End main function
    
   // Ham chuyen tien
    public static boolean chuyen(TaiKhoan acc1, TaiKhoan acc2){
        Scanner sc= new Scanner(System.in);
        System.out.print("vui long nhận số tiền bạn muốn chuyển:");
        // Doc bien kieu double
        double sodu = sc.nextDouble();
        return acc1.ruttien(sodu)&&acc2.them(sodu);
    }    
    
// Ham xem so du
    public static void xemtt(TaiKhoan acc){
        System.out.println("số tài khoản : " + acc.getmatk());
        System.out.println("Chủ tài khoản : " + acc.gettenkh());
        System.out.println("Số dư: " + acc.getsodu());
    }    
    
// Ham rut tien
    public static boolean rut(TaiKhoan acc){
        Scanner sc= new Scanner(System.in);
        System.out.print("nhập số tiền bạn muốn rút:");
        // Doc bien kieu double
        double sodu = sc.nextDouble();
        return acc.ruttien(sodu);
    }       
    
// Ham xu ly login
    public static boolean login(TaiKhoan acc){
        // Yeu cau nguoi dung nhap du lieu
        Scanner sc= new Scanner(System.in);
        System.out.print("vui lòng nhập số tài khoan:");
        // Doc bien kieu Int
        int matk = sc.nextInt();
        System.out.print("mật khẩu:");
        String pass = sc.next();
        //Kiem tra doi chieu tai khoan va mat khau
        return acc.ktra(matk, pass);
    }
        
    public static TaiKhoan newtaikhoan(int mtk, String pass, double sodu, String tkh){
        TaiKhoan acc = new TaiKhoan();
        acc.setmatk(mtk);
        acc.setPassword(pass);
        acc.setsodu(sodu);
        acc.settenkh(tkh);
        return acc;
   }

 
    
}

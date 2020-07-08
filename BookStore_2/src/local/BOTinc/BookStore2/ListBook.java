package local.BOTinc.BookStore2;

public enum ListBook {
	
		JAV(1,10000,"Java"),KOT(2,11000,"kotlin"),SPR(3,12000,"spring"),ANG(4,13000,"angular");
		
		public int nomor,harga;
		public String buku;
		
		private ListBook(int nomor, int harga,String buku) {
			this.nomor = nomor;
			this.harga = harga;
			this.buku = buku;
		}

}

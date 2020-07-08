package local.BOTinc.BookStore2;

import static local.BOTinc.BookStore2.ListBook.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class BookStoreUsingHashMap {
	
	public static Scanner input = new Scanner(System.in);
	public static int pilihanBuku = 0; // PILIHAN BUKU
	public static int jumlahBuku = 0;
	public static int biayaBuku = 0;
	public static int totHargaBuku = 0; // total harga semua buku
	public static int i=0;
	
	// index sebagai identifikasi quantity
	public static HashMap<Integer, Integer> arrQuantityBook = new HashMap<Integer, Integer>();

	public static void main(String[] args) {

		int pilihan = 0; // PILIHAN MENU
		
		int beliLagi = 0; // indikator untuk memilih lagi pada menu list buku (1)
		int hapuslagi = 0; // indikator untuk menghapus lagi pada menu daftar belanja (2)
		int pilihanHapusBuku = 0; // pilihan buku yang akan dihapus

		do {

			System.out.println("1.Tambah/Update Buku yang dibeli");
			System.out.println("2.Daftar Belanja");
			System.out.println("3.Keluar");

			pilihan = getAnInteger();

			if (pilihan == 1) {
				do {
					tampilkan();

					System.out.println("Pilih Buku yang akan di Beli ?");
					pilihanBuku = getAnInteger();

					if (pilihanBuku == 1) {
						saveAndCalculate(10000,1);
					} else if (pilihanBuku == 2) {
						saveAndCalculate(11000,2);
					} else if (pilihanBuku == 3) {
						saveAndCalculate(12000,3);
					} else if (pilihanBuku == 4) {
						saveAndCalculate(13000,4);
					} else {
						break;
					}

					System.out.println("Apakah mau beli lagi ?");
					System.out.println("Pilih 1 untuk pilih kembali");
					System.out.println("Pilih 2 untuk keluar");

					beliLagi = getAnInteger();
					if (beliLagi == 2) {
						break;
					}

				} while (true);
			} else if (pilihan == 2) {

				tampilkanJumlahBukuDanTotalHarga(arrQuantityBook);
				
				System.out.println("Total harga pembelian buku : " + totHargaBuku);

				do {

					System.out.println("Apakah anda ingin menghapus (remove) belanjaan anda ?");
					System.out.println("Pilih 1 untuk ya");
					System.out.println("Pilih 2 untuk tidak");

					hapuslagi = getAnInteger();

					if (hapuslagi == 2) {
						break;
					}

					tampilkan();

					System.out.println("Pilih Buku yang ingin dihapus ");

					pilihanHapusBuku = getAnInteger();
					arrQuantityBook.remove(pilihanHapusBuku);
					
					tampilkanJumlahBukuDanTotalHarga(arrQuantityBook);

				} while (true);

			} else if (pilihan == 3) {
				System.exit(0);
			} else {
				System.out.println("Pilihan tidak ada");
			}

		} while (true);

	}

	public static void tampilkan() {
		System.out.println(JAV.nomor + ". " + JAV.buku + " dengan harga " + JAV.harga);
		System.out.println(KOT.nomor + ". " + KOT.buku + " dengan harga " + KOT.harga);
		System.out.println(SPR.nomor + ". " + SPR.buku + " dengan harga " + SPR.harga);
		System.out.println(ANG.nomor + ". " + ANG.buku + " dengan harga " + ANG.harga);
	}

	public static void tampilkanJumlahBukuDanTotalHarga(HashMap<Integer, Integer> arrQuantityBook) {

		System.out.println("-------------------Keranjang Belanja-------------------");
		
		Iterator<Entry<Integer, Integer>> quantity = arrQuantityBook.entrySet().iterator();

		//initialize value from mapset to array
		while (quantity.hasNext()) {
			Entry<Integer, Integer> me = (Entry<Integer, Integer>) quantity.next();

			if(me.getKey()== 1) {
				biayaBuku = me.getValue()*10000;
				System.out.println(JAV.buku + " sebanyak " + me.getValue() + " dengan total harga " + biayaBuku );
				totHargaBuku = totHargaBuku + biayaBuku;
			}
			else if (me.getKey() == 2) {
				biayaBuku = me.getValue()*11000;
				System.out.println(KOT.buku + " sebanyak " + me.getValue() + " dengan total harga " + biayaBuku);
				totHargaBuku = totHargaBuku + biayaBuku;
			}
			else if (me.getKey() == 3) {
				biayaBuku = me.getValue()*12000;
				System.out.println(SPR.buku + " sebanyak " + me.getValue() + " dengan total harga " + biayaBuku );
				totHargaBuku = totHargaBuku + biayaBuku;
			} else if (me.getKey() == 4) {
				biayaBuku = me.getValue()*13000;
				System.out.println(ANG.buku + " sebanyak " + me.getValue() + " dengan total harga " + biayaBuku );
				totHargaBuku = totHargaBuku + biayaBuku;
			}	
		}
		System.out.println("-------------------------------------------------------");
		
	}
	
	public static Integer getAnInteger() {
		while (true) {
			try {
				return input.nextInt();
			} catch (Exception e) {
				input.next();
				System.err.print("Try again: ");
			}
		}
	}
	
	public static void saveAndCalculate(int harga,int pilihanBuku) {
		System.out.println("Masukkan Jumlah Buku yang akan di Beli ?");
		jumlahBuku = getAnInteger();
		biayaBuku = jumlahBuku * harga;
		arrQuantityBook.put(pilihanBuku, jumlahBuku);
	}

}

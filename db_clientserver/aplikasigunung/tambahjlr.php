<?php
	//Import File Koneksi database
	
	require_once('koneksi.php');
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Mendapatkan Nilai Variable
		$nama = $_POST['nama'];
		$jarak = $_POST['jarak'];
		$wilayah = $_POST['wilayah'];
		
		$sql = "INSERT INTO tb_jalur (nama,jarak,wilayah) VALUES ('$nama','$jarak','$wilayah')";
		
		//Eksekusi Query database
		if(mysqli_query($con,$sql)) {
		echo json_encode(array('status'=>'OK', 'message' => 'Berhasil Tambah Data'));

		}else{
		echo json_encode(array('status'=>'KO', 'message' => 'Gagal Tambah Data'));
		}

		
		
		
		mysqli_close($con);
	}
?>
<?php
if($_SERVER['REQUEST_METHOD']=='POST'){
		//MEndapatkan Nilai Dari Variable 
		$id = $_POST['id'];
		$nama = $_POST['nama'];
		$jarak = $_POST['jarak'];
		$wilayah = $_POST['wilayah'];
		
		//import file koneksi database 
		require_once('koneksi.php');
		
		//Membuat SQL Query
		$sql = "UPDATE tb_jalur SET nama = '$nama', jarak = '$jarak', wilayah = '$wilayah' WHERE id = $id;";
		
		//Meng-update Database 
		if(mysqli_query($con,$sql)) {
		echo json_encode(array('status'=>'OK', 'message' => 'Berhasil Update Data'));

		}else{
		echo json_encode(array('status'=>'KO', 'message' => 'Gagal Update Data'));
		}
		
		mysqli_close($con);
	}
?>

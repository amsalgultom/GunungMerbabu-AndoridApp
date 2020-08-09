<?php
//Import File Koneksi Database
require_once 'koneksi.php';

//Membuat SQL Query
$sql = "SELECT * FROM tb_jalur";

//Mendapatkan Hasil
$r = mysqli_query($con, $sql);

//Membuat Array Kosong
$result = array();

while ($row = mysqli_fetch_array($r)) {

	//Memasukkan Nama dan ID kedalam Array Kosong yang telah dibuat
	array_push($result, array(
		"id" => $row['id'],
		"nama" => $row['nama'],
		"jarak"=>$row['jarak'],
		"wilayah" => $row['wilayah'],
	));
}

//Menampilkan Array dalam Format json_decode(json)
echo json_encode(array('jalur' => $result));

mysqli_close($con);
?>
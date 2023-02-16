<?php

$putdata = fopen("php://input", "r");

/* Open a file for writing*/ 
$fp = fopen("/var/www/html/vpn-config.txt", "w");

/* Read the data and write to the file */
while ($data = fread($putdata, 1024))
  fwrite($fp, $data);

/* Close the streams */
fclose($fp);
fclose($putdata);
?>

<?php 

// shift bytes
$value = 131074;

echo $build = $value &  0x0000FF;
echo $minor= ($value &  0x00FF00) >> 8;
echo $major = ($value &  0xFF0000) >> 16;

$value = 196868;

echo $build = $value &  0x0000FF;
echo $minor= ($value &  0x00FF00) >> 8;
echo $major = ($value &  0xFF0000) >> 16;


// as per name
function generateRandomString($length = 10) {
    $characters = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    $randomString = '';
    for ($i = 0; $i < $length; $i++) {
        $randomString .= $characters[rand(0, strlen($characters) - 1)];
    }
    return $randomString;
}

echo generateRandomString();

//
// my php function
// uses 3 parameters 
// $type - has 3 types - set, unset and check;
// check return 0 - false(not set), 1 - true(set)
// $interestBit - bit to work with
// $value passed value to work with
//

function flagHandle($type, $interestBit, $value) {

	$mask = 1 << $interestBit - 1;

	switch($type){
		case 'set':
			$value |= $mask;
		break;
		case 'unset':
			$value &= ~$mask;
		break;
		case 'check':
			$value = $value & $mask;
			if(($value & $mask)==0){
				$value = 0;
			} else {
				$value = 1;
			}
		break;
	}
	return $value;
}

echo flagHandle("unset", 3, 4);
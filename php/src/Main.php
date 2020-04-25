<?php

namespace App;

include_once './Commands.php';

/**
 * Main file. It will executes the app
 *
 * @author brayvasq
 * @version 0.2
 */
(new Commands($argv))->process();
?>

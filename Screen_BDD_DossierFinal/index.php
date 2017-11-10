<?php
require_once __DIR__ . '/vendor/autoload.php';
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
$app = new Silex\Application();
$app['debug'] = true;
$pdo = new PDO('mysql:dbname=Dahouet;host=localhost;charset=utf8', 'root', '200volt', array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
$app->get('/', function(){
	return new Response(json_encode("Hello world"), 200, array( 'Content-Type' => 'application/json' ));
	//return json_encode("Hello world");
});
$app->get('/challenge/', function() use ($pdo){
	$sql = "SELECT * FROM Challenge";
	$stmt = $pdo->prepare($sql);
	$stmt->execute();
	 // Generate an array of the required objects
	 $arr = $stmt->fetchAll(\PDO::FETCH_OBJ);
	$response = new Response(json_encode($arr),200, array( 'Content-Type' => 'application/json' ));
	$response->setCharset('utf-8');
	return $response;
});
$app->get('/challenge{challenge_id}/Regate/', function(Request $request) use ($pdo){
	$challenge = $request->get('challenge_id');

		$sql = "SELECT * FROM Regate r INNER JOIN Challenge c ON c.challenge_id= r.challenge_id WHERE :challenge_id=r.challenge_id ";
		$stmt = $pdo->prepare($sql);
		$stmt->bindParam(':challenge_id', $challenge);

	//$stmt->debugDumpParams();
	//$stmt->bindParam(':code', $codeTypeFilm);
	$stmt->execute();
	 // Generate an array of the required objects
	 $arr = $stmt->fetchAll(\PDO::FETCH_OBJ);
	$response = new Response(json_encode($arr),200, array( 'Content-Type' => 'application/json' ));
	$response->setCharset('utf-8');
	return $response;
});
$app->get('/challenge/Regate{regate_id}/Resultat/', function($regate_id) use($pdo){


	$sql = "SELECT resultat_tempsreel, resultat_tempscompose,placement,voilier_numVoile FROM resultat r INNER JOIN Regate re ON r.regate_id = re.regate_id
	INNER JOIN Equipage e ON re.regate_id = e.regate_id
  INNER JOIN Voilier v ON e.voilier_id = v.voilier_id
  WHERE :regate_id=r.regate_id";
	$stmt = $pdo->prepare($sql);
	//$stmt->debugDumpParams();
	$stmt->bindParam(':regate_id', $regate_id);
	$stmt->execute();
	 // Generate an array of the required objects
	 $arr = $stmt->fetchAll(\PDO::FETCH_OBJ);
	$response = new Response(json_encode($arr),200, array( 'Content-Type' => 'application/json' ));
	$response->setCharset('utf-8');
	return $response;
});
$app->run();

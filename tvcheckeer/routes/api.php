<?php

use App\Categoria;
use App\Serie;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('serie', function (){

   return Serie::all();
});

Route::get('serie/{id}' ,function($id){
   return Serie::find($id);
});

Route::get('serie/{nome_serie}', function($nome_serie){
   return Serie::find($nome_serie);
});

Route::get('serie/{descricao}', function($descricao){
    return Serie::find($descricao);
});

Route::get('serie/{imdb}', function($imdb){
    return Serie::find($imdb);
});

Route::get('serie/{image}', function($image){
    return Serie::find($image);
});

Route::get('serie/{id_categoria}', function($id_categoria){
    return Serie::find($id_categoria);
});


Route::put('serie/{id}', function(Request $request, $id) {
    $serie = Serie::findOrFail($id);
    $serie->update($request->all());

    return $serie;
});

Route::post('serie/{id}', function($id){
    Serie::find($id)->insert();
});


Route::delete('serie/{id}', function($id) {
    Serie::find($id)->delete();

    return 204;
});

Route::put('serie/{nome}', function(Request $request, $nome) {
    $serie = Serie::findOrFail($nome);
    $serie->update($request->all());

    return $serie;
});

Route::post('serie/{nome}', function($nome){
    Serie::find($nome)->insert();
});


Route::delete('serie/{nome}', function($nome) {
    Serie::find($nome)->delete();

    return 204;
});


Route::get('categoria', function (){

    return Categoria::all();
});

Route::get('categoria/{id}' ,function($id){
    return Categoria::find($id);
});

Route::get('categoria/{nome_categoria}', function($nome_categoria){
    return Categoria::find($nome_categoria);
});


Route::put('categoria/{id}', function(Request $request, $id) {
    $categoria = Categoria::findOrFail($id);
    $categoria->update($request->all());

    return $categoria;
});

Route::post('categoria/{id}', function($id){
    Categoria::find($id)->insert();
});


Route::delete('categoria/{id}', function($id) {
    Categoria::find($id)->delete();

    return 204;
});

Route::put('categoria/{nome}', function(Request $request, $nome) {
    $categoria = Categoria::findOrFail($nome);
    $categoria->update($request->all());

    return $categoria;
});

Route::post('categoria/{nome}', function($nome){
    Categoria::find($nome)->insert();
});


Route::delete('categoria/{nome}', function($nome) {
    Categoria::find($nome)->delete();

    return 204;
});




Route::get('episodios', function (){

    return Episodios::all();
});

Route::get('episodios/{id_categoria}' ,function($id){
    return Episodios::find($id);
});

Route::get('episodios/{nome_episodios}', function($nome_episodios){
    return Episodios::find($nome_episodios);
});


Route::put('episodios/{id_categoria}', function(Request $request, $id) {
    $episodios = Episodios::findOrFail($id);
    $episodios->update($request->all());

    return $episodios;
});

Route::post('episodios/{id_categoria}', function($id){
    Episodios::find($id)->insert();
});


Route::delete('episodios/{id_categoria}', function($id) {
    Episodios::find($id)->delete();

    return 204;
});

Route::put('episodios/{nome}', function(Request $request, $nome) {
    $episodios = Episodios::findOrFail($nome);
    $episodios->update($request->all());

    return $episodios;
});

Route::post('episodios/{nome}', function($nome){
    Episodios::find($nome)->insert();
});


Route::delete('episodios/{nome}', function($nome) {
    Episodios::find($nome)->delete();

    return 204;
});





Route::get('favoritos', function (){

    return Favoritos::all();
});

Route::get('favoritos/{idUser}' ,function($idUser){
    return Favoritos::find($idUser);
});

Route::get('favoritos/{idSerie}', function($idSerie){
    return Favoritos::find($idSerie);
});

Route::get('favoritos/{favorito}', function($favoritos){
    return Favoritos::find($favoritos);
});

Route::get('favoritos/{image}', function($image){
    return Favoritos::find($image);
});


Route::get('vistos', function (){

    return Vistos::all();
});

Route::get('vistos/{idUser}' ,function($idUser){
    return Vistos::find($idUser);
});

Route::get('vistos/{idSerie}', function($idSerie){
    return Vistos::find($idSerie);
});

Route::get('vistos/{visto}', function($visto){
    return Vistos::find($vistos);
});

Route::get('vistos/{image}', function($image){
    return Vistos::find($image);
});





Route::get('serie', 'SerieController@index');
Route::get('serie/{id}', 'SerieController@show');
//Route::get('serie/{nome}', 'SerieController@Name');
Route::post('serie/{nome}', 'SerieController@Name');
Route::put('serie/{id}', 'SerieController@update');
Route::delete('serie/{id}', 'SerieController@delete');


Route::get('categoria', 'CategoriasController@index');
Route::get('categoria/{id}', 'CategoriasController@show');
Route::put('categoria/{id}', 'CategoriasController@update');
Route::delete('categoria/{id}', 'CategoriasController@delete');

Route::get('episodio', 'EpisodiosController@index');
Route::get('episodio/{id}', 'EpisodiosController@show');
Route::put('episodio/{id}', 'EpisodiosController@update');
Route::delete('episodio/{id}', 'EpisodiosController@delete');

Route::get('favorito', 'FavoritosController@index');
Route::get('favorito/{id}', 'FavoritosController@show');
Route::put('favorito/{id}', 'FavoritosController@update');
Route::delete('favorito/{id}', 'FavoritosController@delete');


Route::get('vistos', 'VistosController@index');
Route::get('vistos/{id}', 'VistosController@show');
Route::put('vistos/{id}', 'VistosController@update');
Route::delete('vistos/{id}', 'VistosController@delete');







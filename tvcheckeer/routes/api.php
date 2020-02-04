<?php

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


Route::get('serie', 'SerieController@index');
Route::get('serie/{id}', 'SerieController@show');
//Route::get('serie/{nome}', 'SerieController@Name');
Route::post('serie/{nome}', 'SerieController@Name');
Route::post('articles', 'ArticleController@store');
Route::put('serie/{id}', 'SerieController@update');
Route::delete('serie/{id}', 'SerieController@delete');
//Route::post('login', 'AuthController@login');
//Route::get('logout', 'AuthController@logout');


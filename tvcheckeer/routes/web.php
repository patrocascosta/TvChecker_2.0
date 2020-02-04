<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

use App\Serie;

Route::get('/', function () {
    return view('welcome');
});

Route::get('/serie/{id}', function ($id) {
    return 'This serie is'.$id;
});

Route::get('/home', '@index')->name('home');

Route::get('serie/{nome_serie}', function($nome_serie){
    return Serie::find($nome_serie);
});


Route::get('/', 'PagesController@index');

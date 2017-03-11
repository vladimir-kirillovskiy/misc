<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| This file is where you may define all of the routes that are handled
| by your application. Just tell Laravel the URIs it should respond
| to using a Closure or controller method. Build something great!
|
*/

Route::get('/', 'PagesController@index');

Route::get('profile', 'PagesController@profile')->middleware('authenticated');
Route::get('settings', 'PagesController@settings');

Route::get('blade', 'PagesController@blade');


// Route::get('users', function () {
//       return $users;
// });

Route::get('users', 'UserController@index')->middleware('authenticated');  // use controller with middleware
Route::get('users/create', ['uses' => 'UserController@create']);
Route::post('users', ['uses' => 'UserController@store']); // save to db

Auth::routes();

Route::get('/home', 'HomeController@index');

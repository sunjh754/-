<template>
  <div id="app">
	    <router-view></router-view>
	</div>
</template>

<style>
	/* 公共样式 */
	*{
	    margin: 0;
	    padding: 0;
	    box-sizing: border-box;
	}
	
	html, body {
	    height: 100%;
		width: 100%;
	}
	h1, h2, h3, h4, h5, h6{
	    font-weight:normal;
	}
	ul,li{
	    list-style: none;
	}
	a {
	    text-decoration: none;
	    color: #232323;
	}
	body {
	    color:#333;
	}
	img {
	    border: none;
	    vertical-align: middle;
	}
	
	table {
	    border-collapse: collapse;
	    table-layout: fixed;
	}
	
	input, textarea {
	    outline: none;
	    border: none;
	}
	
	textarea {
	    resize: none;
	    overflow: auto;
	}
	
</style>

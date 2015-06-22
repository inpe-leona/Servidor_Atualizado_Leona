%Modules
module Controller:    br.leona.server.controller.*
module Model:         br.leona.server.model.*
module Service:       br.leona.server.service*
module DAO:           br.leona.server.dao.*
module View:		  br.leona.server.view.*	
module Persistence:   javax.persistence.*
module Esfinge:       org.esfinge.*
module Serializable:  java.io.Serializable.* 
module VRaptor:       br.com.caelum.vraptor.* 
module Component: 	  br.caelum.vraptor.ioc.Component.*
module JOptionPane:    javax.swing.JOptionPane.* 
module Servlet:       br.leona.servidor.servlet.*
module JavaxServlet:  javax.servlet.*
module File: 	      java.io.File.*
module Net: 		  java.net.*
module SQL:		      java.sql.*
module ImageIO:	      javax.imageio.*
module FTP:			  org.apache.commons.net.ftp.*
module Security:	  java.security.*
module Mail: 	      javax.mail.*
	
 
%Constraints
Service can-depend-only Controller
Model must-declare Persistence
only Controller can-depend Controller
only DAO can-declare Esfinge
View cannot-access Model
Model must-declare Serializable
only Controller can-declare VRaptor
only Controller can-declare JOptionPane
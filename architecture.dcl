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
module JavaxSwing:    javax.swing.* 
 
%Constraints
Service can-depend-only Controller
only Model can-declare Persistence
only Controller can-depend Controller
only DAO can-declare Esfinge
View cannot-access Model
Model must-declare Serializable
only Controller can-declare VRaptor
only Controller can-declare JavaxSwing
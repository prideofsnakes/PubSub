PGDMP     ,    3                y            pubsub    10.7    10.13     ?
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            ?
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            ?
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            ?
           1262    24634    pubsub    DATABASE     ?   CREATE DATABASE pubsub WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE pubsub;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            ?
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            ?
           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            ?            1259    24638    purchase    TABLE     ?   CREATE TABLE public.purchase (
    id integer NOT NULL,
    msisdn character varying(20),
    ts timestamp without time zone
);
    DROP TABLE public.purchase;
       public         postgres    false    3            ?            1259    24643    purchase_id_seq    SEQUENCE     ?   ALTER TABLE public.purchase ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.purchase_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public       postgres    false    3    197            ?            1259    24635 	   subscribe    TABLE     ?   CREATE TABLE public.subscribe (
    id integer NOT NULL,
    msisdn character varying(20) NOT NULL,
    ts timestamp without time zone
);
    DROP TABLE public.subscribe;
       public         postgres    false    3            ?            1259    24645    subscribe_id_seq    SEQUENCE     ?   ALTER TABLE public.subscribe ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.subscribe_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public       postgres    false    196    3            ?
          0    24638    purchase 
   TABLE DATA               2   COPY public.purchase (id, msisdn, ts) FROM stdin;
    public       postgres    false    197   |       ?
          0    24635 	   subscribe 
   TABLE DATA               3   COPY public.subscribe (id, msisdn, ts) FROM stdin;
    public       postgres    false    196   ?       ?
           0    0    purchase_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.purchase_id_seq', 1, false);
            public       postgres    false    198            ?
           0    0    subscribe_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.subscribe_id_seq', 1, false);
            public       postgres    false    199            w
           2606    24642    purchase purchase_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.purchase DROP CONSTRAINT purchase_pkey;
       public         postgres    false    197            u
           2606    24651    subscribe subscribe_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.subscribe
    ADD CONSTRAINT subscribe_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.subscribe DROP CONSTRAINT subscribe_pkey;
       public         postgres    false    196            ?
      x?????? ? ?      ?
      x?????? ? ?     
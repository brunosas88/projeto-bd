--
-- PostgreSQL database dump
--

-- Dumped from database version 14.2
-- Dumped by pg_dump version 14.2

-- Started on 2022-04-02 13:16:57

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 3338 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 210 (class 1259 OID 16527)
-- Name: compra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.compra (
    id_compra integer NOT NULL,
    data_compra timestamp without time zone,
    cpf_cliente character varying(11),
    valot_total double precision,
    CONSTRAINT compra_valot_total_check CHECK ((valot_total >= (0)::double precision))
);


ALTER TABLE public.compra OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 16526)
-- Name: compra_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.compra_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.compra_id_seq OWNER TO postgres;

--
-- TOC entry 3339 (class 0 OID 0)
-- Dependencies: 209
-- Name: compra_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.compra_id_seq OWNED BY public.compra.id_compra;


--
-- TOC entry 213 (class 1259 OID 16589)
-- Name: compra_produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.compra_produto (
    id_compra integer NOT NULL,
    id_produto integer NOT NULL,
    qtd integer,
    CONSTRAINT compra_produto_qtd_produto_check CHECK ((qtd > 0))
);


ALTER TABLE public.compra_produto OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16576)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    id_produto integer NOT NULL,
    codigo character varying(13),
    preco double precision,
    qtd_disponivel integer,
    CONSTRAINT produto_preco_check CHECK ((preco > (0)::double precision)),
    CONSTRAINT produto_qtd_disponivel_check CHECK ((qtd_disponivel >= 0))
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 16575)
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_id_seq OWNER TO postgres;

--
-- TOC entry 3340 (class 0 OID 0)
-- Dependencies: 211
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id_produto;


--
-- TOC entry 3173 (class 2604 OID 16530)
-- Name: compra id_compra; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra ALTER COLUMN id_compra SET DEFAULT nextval('public.compra_id_seq'::regclass);


--
-- TOC entry 3175 (class 2604 OID 16579)
-- Name: produto id_produto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN id_produto SET DEFAULT nextval('public.produto_id_seq'::regclass);


--
-- TOC entry 3329 (class 0 OID 16527)
-- Dependencies: 210
-- Data for Name: compra; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.compra VALUES (44, '2022-03-30 11:34:50.592224', '12345678978', 133);


--
-- TOC entry 3332 (class 0 OID 16589)
-- Dependencies: 213
-- Data for Name: compra_produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.compra_produto VALUES (44, 1, 5);
INSERT INTO public.compra_produto VALUES (44, 3, 10);
INSERT INTO public.compra_produto VALUES (44, 4, 3);


--
-- TOC entry 3331 (class 0 OID 16576)
-- Dependencies: 212
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.produto VALUES (1, 'oleosoja11111', 10.5, 300);
INSERT INTO public.produto VALUES (2, 'arroz11111111', 10.5, 300);
INSERT INTO public.produto VALUES (3, 'feijao1111111', 5.5, 100);
INSERT INTO public.produto VALUES (4, 'manteiga11111', 8.5, 50);
INSERT INTO public.produto VALUES (5, 'macarrao11111', 2.5, 1000);
INSERT INTO public.produto VALUES (7, 'granola111111', 29.5, 700);


--
-- TOC entry 3341 (class 0 OID 0)
-- Dependencies: 209
-- Name: compra_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.compra_id_seq', 44, true);


--
-- TOC entry 3342 (class 0 OID 0)
-- Dependencies: 211
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_id_seq', 7, true);


--
-- TOC entry 3180 (class 2606 OID 16533)
-- Name: compra compra_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra
    ADD CONSTRAINT compra_pkey PRIMARY KEY (id_compra);


--
-- TOC entry 3186 (class 2606 OID 16594)
-- Name: compra_produto compra_produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra_produto
    ADD CONSTRAINT compra_produto_pkey PRIMARY KEY (id_compra, id_produto);


--
-- TOC entry 3182 (class 2606 OID 16585)
-- Name: produto produto_codigo_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_codigo_key UNIQUE (codigo);


--
-- TOC entry 3184 (class 2606 OID 16583)
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id_produto);


--
-- TOC entry 3187 (class 2606 OID 16595)
-- Name: compra_produto compra_produto_id_compra_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra_produto
    ADD CONSTRAINT compra_produto_id_compra_fkey FOREIGN KEY (id_compra) REFERENCES public.compra(id_compra);


--
-- TOC entry 3188 (class 2606 OID 16600)
-- Name: compra_produto compra_produto_id_produto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.compra_produto
    ADD CONSTRAINT compra_produto_id_produto_fkey FOREIGN KEY (id_produto) REFERENCES public.produto(id_produto);


-- Completed on 2022-04-02 13:16:57

--
-- PostgreSQL database dump complete
--


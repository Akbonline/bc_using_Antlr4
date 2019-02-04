// Generated from Grammar.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, VAR=11, INT=12, MUL=13, DIV=14, ADD=15, SUB=16, MOD=17, POW=18, 
		EQ=19, GT=20, GE=21, LT=22, LE=23, INCR=24, DECR=25, COMMENT=26, WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "VAR", "INT", "MUL", "DIV", "ADD", "SUB", "MOD", "POW", "EQ", 
			"GT", "GE", "LT", "LE", "INCR", "DECR", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'!'", "'&&'", "'||'", "'sqrt'", "'('", "')'", "'s'", "'c'", "'l'", 
			"'e'", null, null, "'*'", "'/'", "'+'", "'-'", "'%'", "'^'", "'='", "'>'", 
			"'>='", "'<'", "'<='", "'++'", "'--'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "VAR", 
			"INT", "MUL", "DIV", "ADD", "SUB", "MOD", "POW", "EQ", "GT", "GE", "LT", 
			"LE", "INCR", "DECR", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u008f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\6\fT\n\f\r\f\16\fU\3\r\6\rY\n\r\r\r\16\rZ\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\7\33\177\n\33\f\33\16\33\u0082\13\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\34\6\34\u008a\n\34\r\34\16\34\u008b\3\34\3\34\3\u0080\2\35\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\5\5\2C\\aac"+
		"|\3\2\62;\5\2\13\f\17\17\"\"\2\u0092\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7>\3\2\2\2\tA\3\2\2\2\13F\3"+
		"\2\2\2\rH\3\2\2\2\17J\3\2\2\2\21L\3\2\2\2\23N\3\2\2\2\25P\3\2\2\2\27S"+
		"\3\2\2\2\31X\3\2\2\2\33\\\3\2\2\2\35^\3\2\2\2\37`\3\2\2\2!b\3\2\2\2#d"+
		"\3\2\2\2%f\3\2\2\2\'h\3\2\2\2)j\3\2\2\2+l\3\2\2\2-o\3\2\2\2/q\3\2\2\2"+
		"\61t\3\2\2\2\63w\3\2\2\2\65z\3\2\2\2\67\u0089\3\2\2\29:\7#\2\2:\4\3\2"+
		"\2\2;<\7(\2\2<=\7(\2\2=\6\3\2\2\2>?\7~\2\2?@\7~\2\2@\b\3\2\2\2AB\7u\2"+
		"\2BC\7s\2\2CD\7t\2\2DE\7v\2\2E\n\3\2\2\2FG\7*\2\2G\f\3\2\2\2HI\7+\2\2"+
		"I\16\3\2\2\2JK\7u\2\2K\20\3\2\2\2LM\7e\2\2M\22\3\2\2\2NO\7n\2\2O\24\3"+
		"\2\2\2PQ\7g\2\2Q\26\3\2\2\2RT\t\2\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV"+
		"\3\2\2\2V\30\3\2\2\2WY\t\3\2\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2"+
		"[\32\3\2\2\2\\]\7,\2\2]\34\3\2\2\2^_\7\61\2\2_\36\3\2\2\2`a\7-\2\2a \3"+
		"\2\2\2bc\7/\2\2c\"\3\2\2\2de\7\'\2\2e$\3\2\2\2fg\7`\2\2g&\3\2\2\2hi\7"+
		"?\2\2i(\3\2\2\2jk\7@\2\2k*\3\2\2\2lm\7@\2\2mn\7?\2\2n,\3\2\2\2op\7>\2"+
		"\2p.\3\2\2\2qr\7>\2\2rs\7?\2\2s\60\3\2\2\2tu\7-\2\2uv\7-\2\2v\62\3\2\2"+
		"\2wx\7/\2\2xy\7/\2\2y\64\3\2\2\2z{\7\61\2\2{|\7,\2\2|\u0080\3\2\2\2}\177"+
		"\13\2\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080\u0081\3\2\2\2\u0080~\3\2\2"+
		"\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7,\2\2\u0084\u0085"+
		"\7\61\2\2\u0085\u0086\3\2\2\2\u0086\u0087\b\33\2\2\u0087\66\3\2\2\2\u0088"+
		"\u008a\t\4\2\2\u0089\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2"+
		"\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\b\34\2\2\u008e"+
		"8\3\2\2\2\7\2UZ\u0080\u008b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}